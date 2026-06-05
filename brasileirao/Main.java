import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Time> times = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("jogos.txt"));

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(",");

                String timeA = dados[1];
                String timeB = dados[2];
                String resultado = dados[3];

                String[] gols = resultado.split("x");

                int golsA = Integer.parseInt(gols[0]);
                int golsB = Integer.parseInt(gols[1]);

                times.putIfAbsent(timeA, new Time(timeA));
                times.putIfAbsent(timeB, new Time(timeB));

                Time tA = times.get(timeA);
                Time tB = times.get(timeB);

                tA.adicionarGols(golsA, golsB);
                tB.adicionarGols(golsB, golsA);

                if (golsA > golsB) {
                    tA.adicionarPontos(3);
                } else if (golsB > golsA) {
                    tB.adicionarPontos(3);
                } else {
                    tA.adicionarPontos(1);
                    tB.adicionarPontos(1);
                }
            }

            br.close();

            ArrayList<Time> classificacao = new ArrayList<>(times.values());

            Collections.sort(classificacao, new ComparatorTimes());

            System.out.println("+----+----------------+--------+-------+");
            System.out.println("| #  | Time           | Pontos | Saldo |");
            System.out.println("+----+----------------+--------+-------+");

            int posicao = 1;

            for (Time t : classificacao) {
                System.out.printf(
                        "| %-2d | %-14s | %-6d | %-5d |\n",
                        posicao++,
                        t.getNome(),
                        t.getPontos(),
                        t.getSaldoGols()
                );
            }

            System.out.println("+----+----------------+--------+-------+");

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}