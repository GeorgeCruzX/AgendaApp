public class Contato {
    private static int contador = 0;
    private final int id_contato;
    private String nome;
    private String email;
    private String whatsApp;
    private String anotacoes;
    private boolean ativo;

    public Contato(String nome, String email, String whatsApp) {
        this.id_contato = ++contador;
        this.nome = nome;
        this.email = email;
        this.whatsApp = whatsApp;
        this.anotacoes = "";
        this.ativo = true;
    }

    public int getId() { return id_contato; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getWhatsApp() { return whatsApp; }
    public String getAnotacoes() { return anotacoes; }
    public boolean isAtivo() { return ativo; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setWhatsApp(String whatsApp) { this.whatsApp = whatsApp; }
    public void setAnotacoes(String anotacoes) { this.anotacoes = anotacoes; }

    public void alterarContato(String nome, String email, String whatsApp) {
        setNome(nome);
        setEmail(email);
        setWhatsApp(whatsApp);
    }

    public void apagarContato() {
        this.ativo = false;
    }

    public void restaurarContato() {
        this.ativo = true;
    }

    public void mostrarStatus() {
        System.out.println("ID: " + id_contato + " | Nome: " + nome + " | Email: " + email +
                " | WhatsApp: " + whatsApp + " | Ativo: " + ativo);
    }
}