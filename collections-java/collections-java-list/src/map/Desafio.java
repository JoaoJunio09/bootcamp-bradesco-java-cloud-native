package map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Desafio {
    public static void main(String[] args) {

        String path = "C:/Temp/out.txt";

        Map<String, Integer> votacao = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fiels = line.split(",");
                String nome = fiels[0];
                String votos = fiels[1];

                if (votacao.containsKey(nome)) {
                    Integer votosAtual = votacao.get(nome);
                    Integer votosTotal = votosAtual + Integer.parseInt(votos);

                    votacao.put(nome, votosTotal);
                }
                else {
                    votacao.put(nome, Integer.parseInt(votos));
                }

                line = br.readLine();
            }

            for (String key : votacao.keySet()) {
                System.out.println(key + ": " + votacao.get(key));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
