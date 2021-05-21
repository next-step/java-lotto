package lotto.domain;

import java.util.*;

import static lotto.domain.LottoGameOptions.*;

public class Lotto {
    private LottoNumbers numbers;
    private LottoResult result;

    public Lotto() {
        this(true);
    }

    public Lotto(boolean auto) {
        if (auto) {
            this.numbers = new LottoNumbers();
            generateNumbers();
        }
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);

        if (this.numbers.sizeIsNotSameWith(LOTTO_NUMBER_COUNT)) {
            throw new IllegalArgumentException();
        }
    }

    private void generateNumbers() {
        Stack<Integer> wholeLottoNumbers = makeWholeLottoNumbers(LOTTO_NUMBERS_FROM, LOTTO_NUMBERS_TO);

        Collections.shuffle(wholeLottoNumbers);

        while (numbers.sizeIsNotSameWith(LOTTO_NUMBER_COUNT)) {
            numbers.add(wholeLottoNumbers.pop());
        }
    }

    private Stack<Integer> makeWholeLottoNumbers(int start, int end) {
        Stack<Integer> numbers = new Stack<>();
        for (int number = start; number <= end; ++number) {
            numbers.push(number);
        }
        return numbers;
    }

    public String lottoNumberString() {
        return numbers.formattedString();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int numbers(int index) {
        return numbers.get(index);
    }

}
