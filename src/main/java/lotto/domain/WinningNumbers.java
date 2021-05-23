package lotto.domain;

import java.util.HashSet;
import java.util.TreeSet;

public class WinningNumbers {

    private final int NUMBER_COUNT = 6;

    private final TreeSet<LottoNumber> numbers;

    public WinningNumbers(int[] input) throws IllegalArgumentException {
        checkNotNullOrEmpty(input);
        checkNumberCount(input);
        checkDuplicate(input);
        numbers = saveWinningNumbers(input);
    }

    private TreeSet<LottoNumber> saveWinningNumbers(int[] input) {
        TreeSet<LottoNumber> inputs = new TreeSet<>();
        for (int n : input) {
            inputs.add(new LottoNumber(n));
        }
        return inputs;
    }

    private void checkNumberCount(int[] input) throws IllegalArgumentException {
        if (input.length != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNotNullOrEmpty(int[] input) throws IllegalArgumentException {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(int[] input) throws IllegalArgumentException {
        HashSet<LottoNumber> inputs = new HashSet<>();
        for (int n : input) {
            inputs.add(new LottoNumber(n));
        }
        if (inputs.size() < NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }
}
