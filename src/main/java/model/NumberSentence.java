package model;

import java.util.Arrays;
import java.util.List;

public class NumberSentence {
    private final List<String> numberSentence;

    public NumberSentence(String[] numberSentence) {
        this.numberSentence = Arrays.asList(numberSentence);
    }


    public int size() {
        return numberSentence.size();
    }

    public String getExpression(int index) {
        return numberSentence.get(index);
    }
}
