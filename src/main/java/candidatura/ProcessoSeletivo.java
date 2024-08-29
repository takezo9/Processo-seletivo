package candidatura;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProcessoSeletivo {

    public static ArrayList<Candidato> Analise(ArrayList<Candidato> candidatos) {
        ArrayList<Candidato> lista_dos_selecionados = new ArrayList<>();

        double salario_base = 2000;
        int vagas = 5;

        for (Candidato value : candidatos) {
            if (lista_dos_selecionados.size() > vagas) break;
            double salario_pretendido = value.getSalario_pretendido();
            if (salario_pretendido <= salario_base) {
                lista_dos_selecionados.add(value);
            }
        }

        return lista_dos_selecionados;
    }

    public static ArrayList<Candidato> Contato(ArrayList<Candidato> candidatos_selecionados) {
        ArrayList<Candidato> sucesso = new ArrayList<>();

        boolean atendeu = false;
        boolean continuar_tentando = true;
        int tentativas_realizadas = 1;

        for(Candidato candidato:candidatos_selecionados) {
            do {
                atendeu = atender();
                continuar_tentando = !atendeu;

                if (continuar_tentando) {
                    tentativas_realizadas++;
                } else {
                    System.out.println(STR."Contato realizado com o candidato \{candidato.getNome()}");
                    sucesso.add(candidato);
                }

            } while (continuar_tentando && tentativas_realizadas<3);
        }

        return sucesso;
    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }
    public static void main(String[] args) throws Exception{
        //Criando as listas que vão armazenar os candidatos
        ArrayList<Candidato> candidatos = new ArrayList<>();
        ArrayList<Candidato> candidatos_selecionados = new ArrayList<>();

        //Lendo o arquivo com os dados dos candidatos e criando os objetos colocando-os na lista
        String nome_do_arquivo = "src/main/resources/Candidatos.txt";

        try (Scanner in = new Scanner(Paths.get(nome_do_arquivo))) {
            while(in.hasNextLine()) {
                String line = in.nextLine();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",");
                candidatos.add(new Candidato(parts[0],parts[1],parts[2],Double.parseDouble(parts[3])));
            }
        } catch (Exception e) {
            //CALABOCA
            System.err.println("ERRO");
        }

        // Analisando os candidatos
        candidatos_selecionados = Analise(candidatos);

        // Imprimindo lista com os candidatos
        System.out.println(STR."Lista dos candidatos selecionados: \{candidatos_selecionados}");

        //Tentando contato com os candidatos
        ArrayList<Candidato> sucesso = new ArrayList<>();
        sucesso = Contato(candidatos_selecionados);
        if (!sucesso.isEmpty()) {
            System.out.println(STR."O contato foi bem sucedido com os candidatos: \{sucesso}");
        } else {
            System.out.println("O contato com todos os candidatos fracassou.");
        }
    }
}
