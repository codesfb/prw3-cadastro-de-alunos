package br.edu.ifsp.cadastroalunos.dao;

import br.edu.ifsp.cadastroalunos.entity.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.List;

public class AlunoDao {
    private final EntityManager entityManager;

    public AlunoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Aluno aluno){
        this.entityManager.persist(aluno);
    }

    public void excluir(Aluno aluno ){
        this.entityManager.remove(aluno);
    }

    public Aluno buscarPorNome(String nomeDoAluno) throws NoResultException {
        String jpql = "SELECT a FROM Aluno a WHERE a.nome = :n";
        return entityManager.createQuery(jpql, Aluno.class)
                .setParameter("n", nomeDoAluno)
                .getSingleResult();
    }

//    public void alterar(Aluno aluno) {
//        this.entityManager.merge(aluno);
//    }

    public List<Aluno> buscarTodos() {
        String jpql = "SELECT a FROM Aluno a";
        return entityManager.createQuery(jpql, Aluno.class).getResultList();
    }

}
