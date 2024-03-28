package gabriel.aulaweb.gabriel_aulaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@RestController
@RequestMapping("/api/alunos")
public class GabrielAulawebApplication {


    private List<Aluno> alunos = new ArrayList<>();


    public AlunoController() {
        alunos.add(new Aluno("Gabriel", "123456", 18, "M", 8.2));
        alunos.add(new Aluno("Felipe", "654321", 5, "M", 9.1));
        alunos.add(new Aluno("Helena", "222222", 19, "F", 7.3));
        alunos.add(new Aluno("Icaro", "333333", 21, "M", 5.8));
    }


    @GetMapping
    public List<Aluno> todosAlunos() {
        return alunos;
    }


    @GetMapping("/alunos/{ra}")
    public Aluno alunoPorRA(@PathVariable String ra) {
        for (Aluno aluno : alunos) {
            if (aluno.getRa().equals(ra)) {
                return aluno;
            }
        }
        return null;
    }


    @PostMapping("/adicionar")
    public void addAluno(@RequestBody Aluno aluno) {
        alunos.add(aluno);
    }


    @PutMapping("/alunos/{ra}")
    public Aluno updateAluno(@PathVariable String ra, @RequestBody Aluno alunoAtualizado) {
        for (Aluno aluno : alunos) {
            if (aluno.getRa().equals(ra)) {
                aluno.setNome(alunoAtualizado.getNome());
                aluno.setIdade(alunoAtualizado.getIdade());
                aluno.setSexo(alunoAtualizado.getSexo());
                aluno.setMedia(alunoAtualizado.getMedia());
                return aluno;
            }
        }
        return null;
    }


    @DeleteMapping("/alunos/{ra}")
    public void deleteAluno(@PathVariable String ra) {
        alunos.removeIf(aluno -> aluno.getRa().equals(ra));
    }


    public class Aluno {
        private String nome;
        private String ra;
        private int idade;
        private String sexo;
        private double media;


        public Aluno(String nome, String ra, int idade, String sexo, double media) {
            this.nome = nome;
            this.ra = ra;
            this.idade = idade;
            this.sexo = sexo;
            this.media = media;
        }


        public String getNome() {
            return nome;
        }
   
        public String getRa() {
            return ra;
        }
   
        public int getIdade() {
            return idade;
        }
   
        public String getSexo() {
            return sexo;
        }
   
        public Double getMedia() {
            return media;
        }
   
        public void setNome(String nome) {
            this.nome = nome;
        }
   
        public void setRa(String ra) {
            this.ra = ra;
        }
   
        public void setIdade(int idade) {
            this.idade = idade;
        }
   
        public void setSexo(String sexo) {
            this.sexo = sexo;
        }
   
        public void setMedia(double media) {
            this.media = media;
        }
    }
}
