import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) {
        imprimirSelecionados();
        selecaoCandidatos();

        String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando) 
                tentativasRealizadas++;
            else 
                System.out.println("Contato realizado com sucesso!");
            

        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu)
            System.out.println("Conseguimos contatdo com " + candidato + " na " + tentativasRealizadas + "° tentativa.");
        else 
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas.");
    }

    static boolean atender () {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela"}; 
        System.out.println("Imprimindo a lista de candidatos");

        for (int index = 0; index < candidatos.length; index++){
            System.out.println("O candidato de nº " + (index+1) + " é " + candidatos[index]);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        DecimalFormat df = new DecimalFormat("#.00"); // Para imprimir apenas duas casas decimais

        while (candidatosSelecionados < 5) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: R$" + df.format(salarioPretendido));
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }
}