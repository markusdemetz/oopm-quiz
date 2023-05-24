import java.util.Scanner;

public class Quiz {
    final static int MAX = 100;
    static Scanner scanner = new Scanner(System.in);
    private LeichteFrage[] leichteFragen = new LeichteFrage[MAX];
    int anzahlFragen = 0;

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.initQuestions();
        quiz.start();
        scanner.close();
    }

    public void initQuestions() {
        YesNoQuestion q1 = new YesNoQuestion(
                "Die Erde ist eine Scheibe",
                1,
                false
        );
        GapQuestion q2 = new GapQuestion(
                "Objekte sind _________ einer Klasse.",
                10,
                "Instanzen"
        );
        SingleChoiceQuestion q3 = new SingleChoiceQuestion(
                "Wieviele Grundfarben gibt es?",
                5
        );

       addEasyQuestion(q1);
       addEasyQuestion(q2);
    }

    private void addEasyQuestion(LeichteFrage frage) {
        leichteFragen[anzahlFragen++] = frage;
    }

    public void start() {
        int punkte = 0;
        for (int i = 0; i < anzahlFragen; i++) {
            System.out.print("Frage Nr. " + (i+1) + ": ");
            System.out.println(leichteFragen[i].getText());
            System.out.print("Ihre Antwort: ");
            String antwort = scanner.nextLine();
            boolean correct = leichteFragen[i].verify(antwort);
            if (correct) {
                System.out.println("Antwort ist richtig!");
                punkte += leichteFragen[i].getPoints();
            } else {
                System.out.println("Antwort ist falsch!");
            }
        }
        System.out.println("Anzahl Punkte: " + punkte);
    }

}
