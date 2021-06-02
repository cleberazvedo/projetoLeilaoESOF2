package test;

import model.Avaliador;
import model.Lance;
import model.Leilao;
import model.Usuario;

public class TesteDoAvaliador {
    public static void main(String[] args) {
        Usuario joao = new Usuario("Miguel");
        Usuario jose = new Usuario("Marlos");
        Usuario maria = new Usuario("Luiza");
        Leilao leilao = new Leilao("Jogo de Xadrez do Papa");

        // leilao.propoe(new Lance(miguel,600.0));
        // leilao.propoe(new Lance(marlos,700.0));
        // leilao.propoe(new Lance(luiza,250.0));

        leilao.propoe(new Lance(Luiza,566.0));
        leilao.propoe(new Lance(Miguel,678.0));
        leilao.propoe(new Lance(Marlos,400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        // imprime 678.0
        System.out.println(leiloeiro.getMaiorLance());
        // imprime 400.0
        System.out.println(leiloeiro.getMenorLance());
    }
}
