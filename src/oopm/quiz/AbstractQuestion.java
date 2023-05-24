package oopm.quiz;

public abstract class AbstractQuestion implements Question {

    private String text;
    private int points;

    public AbstractQuestion(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public abstract boolean verify(String input);

    @Override
    public int getPoints() {
        return points;
    }

}
