package oopm.quiz;

import java.util.List;

public class SingleChoiceQuestion extends AbstractQuestion
    implements SchwereFrage {

    private List<Choice> choices;

    public SingleChoiceQuestion(String text, int points, List<Choice> choices) {
        super(text, points);
        this.choices = choices;
    }

    @Override
    public boolean verify(String input) {
        int auswahl = Integer.parseInt(input);
        return choices.get(auswahl - 1).isCorrect();
    }

    @Override
    public int plusPunkte() {
        return 2;
    }

    @Override
    public String getText() {
        String s = super.getText() + System.lineSeparator();
        for (int i = 0; i < choices.size(); i++) {
            s += (i + 1) + ": " + choices.get(i).getText() + System.lineSeparator();
        }
        return s;
    }
}
