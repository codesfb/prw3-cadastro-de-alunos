package br.edu.ifsp.cadastroalunos.service;

import br.edu.ifsp.cadastroalunos.entity.Aluno;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CadastroDeAluno {


    public static void cadastrar(Scanner scanner, AlunoService alunoService) {
        System.out.println("--- CADASTRO DE ALUNO ---");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o RA: ");
        String ra = scanner.nextLine();

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a Nota 1: ");
        BigDecimal nota1 = new BigDecimal(scanner.nextLine());

        System.out.print("Digite a Nota 2: ");
        BigDecimal nota2 = new BigDecimal(scanner.nextLine());

        System.out.print("Digite a Nota 3: ");
        BigDecimal nota3 = new BigDecimal(scanner.nextLine());

        Aluno aluno = new Aluno(nome, ra, email, nota1, nota2, nota3);
        alunoService.cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso!");

    }

    public static void listar(AlunoService alunoService) {
        System.out.println("--- LISTA DE ALUNOS ---");
        List<Aluno> alunos = alunoService.listarTodos();

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        }

        alunos.forEach(a -> {
            BigDecimal media = alunoService.calcularMedia(a);
            String situacao = alunoService.determinarSituacao(media);

            System.out.println("Nome: " + a.getNome());
            System.out.println("Email: " + a.getEmail());
            System.out.println("RA: " + a.getRa());
            System.out.println("Notas: " + a.getNota1() + " - " + a.getNota2() + " - " + a.getNota3());
            System.out.println("Média: " + media);
            System.out.println("Situação: " + situacao);
            System.out.println("----------------------------------------");
        });
    }

    public static void buscar(Scanner scanner, AlunoService alunoService) {
        System.out.println("--- CONSULTAR ALUNO ---");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        try {
            Aluno a = alunoService.buscarPorNome(nome);
            System.out.println("Nome: " + a.getNome());
            System.out.println("Email: " + a.getEmail());
            System.out.println("RA: " + a.getRa());
            System.out.println("Notas: " + a.getNota1() + " - " + a.getNota2() + " - " + a.getNota3()); //[cite: 3]
        } catch (Exception e) {
            System.out.println("Aluno não encontrado!");
        }

    }

    public static void alterar(Scanner scanner, AlunoService alunoService) {
        System.out.println("--- ALTERAR ALUNO ---");
        System.out.print("Digite o nome do aluno que deseja alterar: ");
        String nomeBusca = scanner.nextLine();

        try {
            Aluno atual = alunoService.buscarPorNome(nomeBusca);
            System.out.println("Aluno encontrado: " + atual.getNome() + " (RA: " + atual.getRa() + ")");
            System.out.println("NOVOS DADOS:");

            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();

            System.out.print("Digite o novo RA: ");
            String novoRa = scanner.nextLine();

            System.out.print("Digite o novo email: ");
            String novoEmail = scanner.nextLine();

            System.out.print("Digite a nova Nota 1: ");
            BigDecimal n1 = new BigDecimal(scanner.nextLine());

            System.out.print("Digite a nova Nota 2: ");
            BigDecimal n2 = new BigDecimal(scanner.nextLine());

            System.out.print("Digite a nova Nota 3: ");
            BigDecimal n3 = new BigDecimal(scanner.nextLine());

            alunoService.alterarAluno(nomeBusca, novoNome, novoRa, novoEmail, n1, n2, n3);
            System.out.println("Aluno alterado com sucesso!");

        } catch (Exception e) {
            System.out.println("Aluno não encontrado!");
        }

    }

    public static void excluir(Scanner scanner, AlunoService alunoService) {
        System.out.println("--- EXCLUIR ALUNO ---");
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        if (alunoService.excluirAlunoPorNome(nome)) {
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }

    }

}
