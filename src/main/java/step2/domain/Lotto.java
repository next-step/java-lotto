package step2.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int RANGE_OF_LOTTO_NUMBER = 45;
    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> lottoNumbers = new ArrayList<>();

    public Lotto() {
        this.numbers = generateLottoNumber();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> generateLottoNumber() {
        initialLottoNumber();
        for (int i = 1; i <= LOTTO_NUMBER_COUNT; i++) {
            numbers.add(lottoNumbers.get(i));
        }
        Collections.sort(numbers);
        return numbers;
    }

    private void initialLottoNumber() {
        for (int i = 1; i <= RANGE_OF_LOTTO_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
    }
}
