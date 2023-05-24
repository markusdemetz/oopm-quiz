package oopm.quiz;

<<<<<<< HEAD
public abstract class AbstractQuestion implements Question, Comparable<Question> {
=======
public abstract class AbstractQuestion implements Question {
>>>>>>> e6b362ed5f1b5a1e9d7bc3b8cc7f4ef235e2b19d

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

    @Override
    public int compareTo(Question o) {
        // Nach Fragentext alphabetisch sortiert.
        // return getText().compareTo(o.getText()) * -1;
        return Integer.compare(this.getPoints(), o.getPoints());
        //return Integer.valueOf(this.getPoints()).compareTo(Integer.valueOf(o.getPoints()));
    }

}
