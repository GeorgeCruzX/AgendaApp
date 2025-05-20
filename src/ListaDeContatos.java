import java.util.ArrayList;

public class ListaDeContatos {
    private final ArrayList<Contato> contatos = new ArrayList<>();

    public void criarContato(String nome, String email, String whatsApp) {
        contatos.add(new Contato(nome, email, whatsApp));
        System.out.println("Contato criado com sucesso.");
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato na agenda.");
        } else {
            for (Contato c : contatos) {
                c.mostrarStatus();
            }
        }
    }

    public Contato buscarContatoPorNome(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) return c;
        }
        return null;
    }

    public Contato buscarContatoPorEmail(String email) {
        for (Contato c : contatos) {
            if (c.getEmail().equalsIgnoreCase(email)) return c;
        }
        return null;
    }

    public Contato buscarContatoPorWhatsApp(String whatsApp) {
        for (Contato c : contatos) {
            if (c.getWhatsApp().equalsIgnoreCase(whatsApp)) return c;
        }
        return null;
    }

    public Contato buscarContatoPorId(int id) {
        for (Contato c : contatos) {
            if (c.getId() == id) return c;
        }
        return null;
    }
}