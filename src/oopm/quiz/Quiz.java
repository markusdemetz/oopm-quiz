package oopm.quiz;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    final static int MAX = 100;
    static Scanner scanner = new Scanner(System.in);
    private List<Question> fragen = new ArrayList<>();

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

       fragen.add(q1);
       fragen.add(q2);
    }

    public void start() {
        int punkte = 0;
        for (int i = 0; i < fragen.size(); i++) {
            System.out.print("Frage Nr. " + (i+1) + ": ");
            System.out.println(fragen.get(i).getText());
            System.out.print("Ihre Antwort: ");
            String antwort = scanner.nextLine();
            boolean correct = fragen.get(i).verify(antwort);
            if (correct) {
                System.out.println("Antwort ist richtig!");
                punkte += fragen.get(i).getPoints();
            } else {
                System.out.println("Antwort ist falsch!");
            }
        }
        System.out.println("Anzahl Punkte: " + punkte);
    }

}
