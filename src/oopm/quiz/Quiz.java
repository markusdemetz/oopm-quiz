package oopm.quiz;

import java.util.Iterator;
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
                "Z Die Erde ist eine Scheibe (1 Pkt.)",
                1,
                false
        );
        GapQuestion q2 = new GapQuestion(
                "A Objekte sind _________ einer Klasse. (10 Pkt.)",
                10,
                "Instanzen"
        );
        SingleChoiceQuestion q3 = new SingleChoiceQuestion(
                "X Wieviele Grundfarben gibt es? (5. Pkt.)",
                5
        );

       fragen.add(q1);
       fragen.add(q2);
       fragen.add(q3);
    }

    public void start() {
        PunkteComparator comparator = new PunkteComparator();
        fragen.sort(comparator);
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
