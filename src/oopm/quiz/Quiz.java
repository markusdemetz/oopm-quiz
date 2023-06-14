package oopm.quiz;
import java.io.FileWriter;
import java.lang.System;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    final static int MAX = 100;
    static Scanner scanner = new Scanner(System.in);
    private List<Question> fragen = new ArrayList<>();

    public static void main(String[] args) {
        boolean playMode = true;
        if (args.length > 0) {
          if (args[0].equalsIgnoreCase("file")) {
            playMode = false;
          }
        }
        Quiz quiz = new Quiz();
        quiz.initQuestions();
        if (playMode) {
            quiz.start();
        } else {
            quiz.writeQuestionsToFile("fragen.txt");
        }
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
                5,
                List.of(
                        new Choice("Es gibt 2 Grundfarben", false),
                        new Choice("Es gibt 4 Grundfarben", false),
                        new Choice("Es gibt 3 Grundfarben", true),
                        new Choice("Es gibt 6 Grundfarben", false)
                )
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
            System.out.print("Frage Nr. " + (i + 1) + ": ");
            System.out.println(fragen.get(i).getText());
            System.out.print("Ihre Antwort: ");
            String antwort;
            try {
                antwort = eingabe();
            } catch(IOException ioe) {
                System.err.println("Fehler!");
                throw new RuntimeException("Keine Eingabe vorhanden", ioe);
            } finally {
                System.out.println("Finally Block ausgeführt!");
            }
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

    private static String eingabe() throws IOException{
        String eingabe = scanner.nextLine();
        if (eingabe.isBlank()) {
            throw new IOException("Fehlende Eingabe");
        }
        return eingabe;
    }

    private void writeQuestionsToFile(String fileName) {

        try (FileWriter fw = new FileWriter(fileName)) {
            // Über Fragen iterieren und mit FileWriter schreiben.
            fw.write("Quiz Fragen\n");
            for (int i = 0; i < fragen.size(); i++) {
                fw.write(fragen.get(i).getText() + "\n");
            }
            System.out.println("Fragen wurden gespeichert!");
        } catch(IOException e) {
            System.err.println("Fehler beim Schreiben der Datei!");
        }
    }

}
