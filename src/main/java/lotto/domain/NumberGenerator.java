package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    static final int LOTTO_START_NUM = 1;
    static final int LOTTO_END_NUM = 45;
    static final int LOTTO_NUMBER_COUNT = 6;
    static final String ONLY_NUMBER_PATTER = "^[0-9]*$";


    public List<Integer> generateNumbers() {
        List<Integer> baseNumbers = getBaseNumbers();
        Collections.shuffle(baseNumbers);
        return baseNumbers.subList(0, LOTTO_NUMBER_COUNT);
    }

    public List<Integer> generateNumbers(String text) {
        List<Integer> numbers = new ArrayList<>();
        String[] tokens = getTokens(text);

        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }

    private List<Integer> getBaseNumbers() {
        List<Integer> baseNumbers = new ArrayList<>();
        for (int i = LOTTO_START_NUM; i <= LOTTO_END_NUM; i++) {
            baseNumbers.add(i);
        }
        return baseNumbers;
    }

    private String[] getTokens(String text) {
        String[] tokens = text.trim().split(",");
        if (isNotRightCount(tokens) || isNotNumber(tokens)) {
            throw new RuntimeException();
        }
        return tokens;
    }

    private boolean isNotRightCount(String[] tokens) {
        return (tokens.length != LOTTO_NUMBER_COUNT);
    }

    private boolean isNotNumber(String[] tokens) {
        int notNumberCount = (int) Arrays.stream(tokens)
                .filter(token -> !token.matches(ONLY_NUMBER_PATTER))
                .count();
        return (notNumberCount > 0);
    }


}
