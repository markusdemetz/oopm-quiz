package oopm.quiz;

import java.util.Comparator;

public class PunkteComparator implements Comparator<Question> {

    @Override
    public int compare(Question o1, Question o2) {
        return Integer.compare(o1.getPoints(), o2.getPoints());
    }

}
