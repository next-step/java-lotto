package step1.domain;

import java.util.stream.Stream;

public class Calcurator {
    public static final int MIN_WIDTH = 0;

    private final Texts texts;
    private int sum;

    public Calcurator(String text) {
        this.texts = new Texts(text);
    }

    public void sum() {
        sum = Stream.of(texts.getTexts())
                .mapToInt(text -> {
                    Number number = new Number(text);
                    return number.getNumber();
                })
                .sum();
    }

    public int getSum() {
        return sum;
    }
}
