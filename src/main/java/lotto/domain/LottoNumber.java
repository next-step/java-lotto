package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private List<Integer> lottoNumber;

    private LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of() {
        List<Integer> numbers = ShuffleNumber.shuffle(START_NUMBER, END_NUMBER);
        List<Integer> lottoNumber = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumber.add(numbers.get(i));
        }
        Collections.sort(lottoNumber);
        return new LottoNumber(lottoNumber);
    }

    public static LottoNumber of(List<Integer> numbers) {
        return new LottoNumber(numbers);
    }

    public int compare(List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (lottoNumber.contains(winningNumbers.get(i)))
                count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
