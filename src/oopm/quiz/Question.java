package oopm.quiz;

public interface Question {

    String getText();

    boolean verify(String input);

    int getPoints();

}
