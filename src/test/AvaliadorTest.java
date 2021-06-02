package test;

import model.Avaliador;
import model.Lance;
import model.Leilao;
import model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvaliadorTest {

    private Usuario Miguel;
    private Usuario jose;
    private Usuario Luiza;
    private Avaliador leiloeiro;

    @Test
    public void deveEntenderLancesEmOrdemCrescente(){
        // cenário: 3 lances em ordem crescente
        Usuario Miguel = new Usuario("Miguel");
        Usuario jose = new Usuario("Marlos");
        Usuario Luiza = new Usuario("Luiza");
        Leilao leilao = new Leilao("Jogo de Xadrez do Papa");
        leilao.propoe(new Lance(Luiza,250.0));
        leilao.propoe(new Lance(Miguel,300.0));
        leilao.propoe(new Lance(jose,400.0));
        // executando a ação
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        // comparando a saída com o esperado
        double maiorEsperado = 400;
        double menorEsperado = 250;
        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
    }
    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Usuario Miguel = new Usuario("Miguel");
        Leilao leilao = new Leilao("Jogo de Xadrez do Papa");
        leilao.propoe(new Lance(Miguel, 1000.0));
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario Miguel = new Usuario("João");
        Usuario Luiza = new Usuario("Luiza");
        Leilao leilao = new Leilao("Jogo de Xadrez do Papa");
        leilao.propoe(new Lance(Miguel, 100.0));
        leilao.propoe(new Lance(Luiza, 200.0));
        leilao.propoe(new Lance(Miguel, 300.0));
        leilao.propoe(new Lance(Luiza, 400.0));
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }

    @BeforeEach
    private void instanciarObjetos() {
        Miguel = new Usuario("Miguel");
        jose = new Usuario("Marlos");
        Luiza = new Usuario("Luiza");
        leiloeiro = new Avaliador();
        Leilao leilao = new Leilao("Jogo de Xadrez do Papa");
    }
}
