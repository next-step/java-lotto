package lotto.domain;

import java.util.*;

import static lotto.domain.LottoGameOptions.*;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();

    public Lotto() {
        this(true);
    }

    public Lotto(boolean auto) {
        if (auto) {
            generateNumbers();
        }
    }

    private void generateNumbers() {
        Stack<Integer> lottoNumbers = makeWholeLottoNumbers(LOTTO_NUMBERS_FROM, LOTTO_NUMBERS_TO);
        Collections.shuffle(lottoNumbers);
        while (numbers.size() != LOTTO_NUMBER_COUNT) {
            numbers.add(lottoNumbers.pop());
        }
    }

    private Stack<Integer> makeWholeLottoNumbers(int start, int end) {
        Stack<Integer> numbers = new Stack<>();
        for (int number = start; number <= end; ++number) {
            numbers.push(number);
        }
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
