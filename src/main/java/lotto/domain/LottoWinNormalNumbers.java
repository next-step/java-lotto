package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoGameOptions.*;

public class LottoWinNormalNumbers {

    private List<Integer> normalNumbers = new ArrayList<>();

    public LottoWinNormalNumbers(String numbers) {
        initWinNumbers(numbers.split(", |,"));
    }

    private void initWinNumbers(String[] winNums) {
        if (invalid(winNums)) {
            throw new IllegalArgumentException();
        }

        for (String num : winNums) {
            addWinNumber(Integer.parseInt(num));
        }
    }

    private boolean invalid(String[] numberStrings) {
        return numberStrings.length != LOTTO_NUMBER_COUNT;
    }

    private void addWinNumber(int num) {
        if (num < LOTTO_NUMBERS_FROM || num > LOTTO_NUMBERS_TO) {
            throw new IllegalArgumentException();
        }
        normalNumbers.add(num);
    }

    public void add(int num) {
        normalNumbers.add(num);
    }

    public Stream<Integer> stream() {
        return normalNumbers.stream();
    }
}
