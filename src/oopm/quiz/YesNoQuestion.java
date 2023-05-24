package oopm.quiz;

public class YesNoQuestion extends AbstractQuestion
        implements LeichteFrage {

    private boolean correct;

    public YesNoQuestion(String text, int punkteZahl, boolean correct) {
        super(text, punkteZahl);
        this.correct = correct;
    }

    @Override
    public boolean verify(String input) {
        switch (input.toLowerCase()) {
            case "j":
            case "ja":
            case "y":
            case "yes":
            case "true":
            case "t":
                return correct == true;
            default:
                return correct == false;
        }
    }

    @Override
    public int minusPunkte() {
        return 2;
    }

}
