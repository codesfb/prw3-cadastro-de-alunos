package br.edu.ifsp.cadastroalunos;

import br.edu.ifsp.cadastroalunos.service.AlunoService;
import br.edu.ifsp.cadastroalunos.util.JPAUtil;
import br.edu.ifsp.cadastroalunos.view.Menu;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

import static br.edu.ifsp.cadastroalunos.service.CadastroDeAluno.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = JPAUtil.getEntityManager();
        AlunoService alunoService = new AlunoService(em);

        int op = 0;

        do{
            Menu.exibir();

            try {
                op = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite apenas números.");
                continue;
            }

            System.out.println();

            switch (op){
                case 1 -> cadastrar(scanner, alunoService);
                case 2 -> excluir(scanner, alunoService);
                case 3 -> alterar(scanner, alunoService);
                case 4 -> buscar(scanner, alunoService);
                case 5 -> listar(alunoService);
                case 6 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida!");
            }

        }while(op!=6);

        em.close();
        scanner.close();

    }
}
