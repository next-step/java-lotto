package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int MAX_MATCH_NUMBER = 6;
    private final List<Integer> lotto;

    public Lotto() {
        this.lotto = getRandomNumbers();
    }

    public Lotto(List<Integer> numbers) {
        this.lotto = numbers;
    }

    public Lotto(String numbers) {
        this.lotto = new ArrayList<>();
        String[] numberArray = numbers.split(", ");
        for (String number : numberArray) {
            this.lotto.add(Integer.parseInt(number));
        }
    }

    private List<Integer> makeNumberArray() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public List<Integer> getRandomNumbers() {
        List<Integer> numbers = makeNumberArray();
        Collections.shuffle(numbers);
        List<Integer> sixNumbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            sixNumbers.add(numbers.get(i));
        }
        return sixNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lotto;
    }

    public int getSameNumbers(Lotto winning) {
        if (this.isEqual(winning)) return MAX_MATCH_NUMBER;

        List<Integer> winningNumbers = winning.getLottoNumbers();
        Collections.sort(winningNumbers);
        Collections.sort(this.lotto);

        return winningNumbers.stream()
                .filter(winningNum -> lotto.contains(winningNum))
                .collect(Collectors.toList())
                .size();
    }

    public String toString() {
        return this.lotto.toString();
    }


    public boolean isEqual(Lotto numbers) {
        return this.lotto.containsAll(numbers.lotto);
    }
}
