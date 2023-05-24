public class SingleChoiceQuestion extends AbstractQuestion 
    implements SchwereFrage {

    public SingleChoiceQuestion(String text, int points) {
        super(text, points);
    }

    @Override
    public boolean verify(String input) {
        return false;
    }

    @Override
    public int plusPunkte() {
        return 2;
    }
}
