# Cadastro de alunos 
*cadatrato de alunos usando jpa*
---

## checklist 
- [ ] casdastrae aluno 
- [ ] excluir aluno 
- [ ] alterar aluno 
- [ ] buscar aluno pelo nome 
- [ ] listar alunos (com stutus aprovado)
- fim 

---
## arquitetura 

src/
├── main/
│   ├── java/
│   │   └── br/
│   │       └── edu/
│   │           └── ifsp/
│   │               └── cadastroalunos/
│   │                   ├── Main.java
│   │                   │
│   │                   ├── entity/
│   │                   │   └── Aluno.java
│   │                   │
│   │                   ├── dao/
│   │                   │   └── AlunoDao.java
│   │                   │
│   │                   ├── service/
│   │                   │   └── AlunoService.java
│   │                   │
│   │                   ├── view/
│   │                   │   └── Menu.java
│   │                   │
│   │                   └── util/
│   │                       └── JPAUtil.java
│   │
│   └── resources/
│       └── META-INF/
│           └── persistence.xml
│
└── pom.xml
