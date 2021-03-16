package step1.domain;

import java.util.stream.Stream;

public class Calcurator {
    private Calcurator() {}

    public static int getSum(Texts texts) {
        return Stream.of(texts.getTexts())
                .mapToInt(text -> {
                    NaturalNumber naturalNumber = new NaturalNumber(text);
                    return naturalNumber.getNumber();
                })
                .sum();
    }
}
