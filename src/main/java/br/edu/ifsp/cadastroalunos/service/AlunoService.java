package br.edu.ifsp.cadastroalunos.service;

import br.edu.ifsp.cadastroalunos.dao.AlunoDao;
import br.edu.ifsp.cadastroalunos.entity.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AlunoService {

        private final AlunoDao alunoDao;
        private final EntityManager em;

        public AlunoService(EntityManager em) {
            this.em = em;
            this.alunoDao = new AlunoDao(em);
        }

        public void cadastrarAluno(Aluno aluno) {
            em.getTransaction().begin();
            alunoDao.cadastrar(aluno);
            em.getTransaction().commit();
        }

        public boolean excluirAlunoPorNome(String nome) {
            try {
                Aluno aluno = alunoDao.buscarPorNome(nome);
                em.getTransaction().begin();
                alunoDao.excluir(aluno);
                em.getTransaction().commit();
                return true;
            } catch (NoResultException e) {
                return false;
            }
        }

        public boolean alterarAluno(String nomeBusca, String novoNome, String novoRa, String novoEmail,
                                    BigDecimal novaNota1, BigDecimal novaNota2, BigDecimal novaNota3) {
            try {
                Aluno aluno = alunoDao.buscarPorNome(nomeBusca);

                em.getTransaction().begin();
                aluno.setNome(novoNome);
                aluno.setRa(novoRa);
                aluno.setEmail(novoEmail);
                aluno.setNota1(novaNota1);
                aluno.setNota2(novaNota2);
                aluno.setNota3(novaNota3);
                em.getTransaction().commit();

                return true;
            } catch (NoResultException e) {
                return false;
            }
        }

        public Aluno buscarPorNome(String nome) throws NoResultException {
            return alunoDao.buscarPorNome(nome);
        }


        public List<Aluno> listarTodos() {
            return alunoDao.buscarTodos();
        }

        // Regras de Negócio (Cálculos de Média e Situação de Aprovação)

        public BigDecimal calcularMedia(Aluno aluno) {
            BigDecimal soma = aluno.getNota1()
                    .add(aluno.getNota2())
                    .add(aluno.getNota3());

            return soma.divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
        }

        public String determinarSituacao(BigDecimal media) {
            if (media.compareTo(new BigDecimal("6.00")) >= 0) {
                return "Aprovado";
            } else if (media.compareTo(new BigDecimal("4.00")) >= 0) {
                return "Recuperação";
            } else {
                return "Reprovado";
            }
        }
}
