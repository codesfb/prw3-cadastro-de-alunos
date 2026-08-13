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

    public void excluir(String nomeDoAluno){
        Aluno aluno = buscarPorNome(nomeDoAluno);
        this.entityManager.remove(aluno);
    }

    public Aluno buscarPorNome(String nomeDoAluno) throws NoResultException {
        String jpql = "SELECT a FROM Aluno a WHERE a.nome = :n";
        return entityManager.createQuery(jpql, Aluno.class)
                .setParameter("n", nomeDoAluno)
                .getSingleResult();
    }

    //não é nessario um metodo update interiro aqui
    //pq ele entra em estado managed ao buscar
    //O merge garante que o objeto seja reanexado e atualizado no banco
    public void alterar(Aluno aluno) {
        this.entityManager.merge(aluno);
    }

    public List<Aluno> buscarTodos() {
        String jpql = "SELECT a FROM Aluno a";
        return entityManager.createQuery(jpql, Aluno.class).getResultList();
    }

}
