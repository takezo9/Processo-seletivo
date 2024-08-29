package candidatura;

public class Candidato {
    private String nome;
    private String email;
    private String numero_celular;
    private double salario_pretendido;


    public Candidato(String nome,String email, String numero_celular, double salario_pretendido) {
        this.nome = nome;
        this.email = email;
        this.numero_celular = numero_celular;
        this.salario_pretendido = salario_pretendido;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero_celular() {
        return numero_celular;
    }

    public void setNumero_celular(String numero_celular) {
        this.numero_celular = numero_celular;
    }

    public double getSalario_pretendido() {
        return salario_pretendido;
    }

    public void setSalario_pretendido(double salario_pretendido) {
        this.salario_pretendido = salario_pretendido;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", numero_celular='" + numero_celular + '\'' +
                ", salario_pretendido=" + salario_pretendido +
                '}';
    }
}
