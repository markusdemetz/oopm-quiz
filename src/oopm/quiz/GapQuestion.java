package oopm.quiz;

public class GapQuestion extends AbstractQuestion
        implements LeichteFrage {

    private String answer;

    public GapQuestion(String text, int punkteZahl, String antwort) {
        super(text, punkteZahl);
        this.answer = antwort;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean verify(String input) {
        return input.equals(this.answer);
    }

    @Override
    public int minusPunkte() {
        return 1;
    }
}
