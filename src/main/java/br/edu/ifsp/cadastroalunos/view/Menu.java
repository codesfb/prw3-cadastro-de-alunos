package br.edu.ifsp.cadastroalunos.view;

public class Menu {
    public static void  exibir(){
        System.out.println("""
                ** CADASTRO DE ALUNOS **
                1 - Cadastrar aluno
                2 - Excluir aluno
                3 - Alterar aluno
                4 - Buscar aluno pelo nome
                5 - Listar alunos (com status de aprovação)
                6 - FIM
                """);
    }
}
