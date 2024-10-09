package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private static final int START = 0;
    private static final int END = 6;

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            lottoNumbers.add(i);
        }
    }

    public List<Integer> pickLottoNumber() {

        ArrayList<Integer> baseNumbers = new ArrayList<>(lottoNumbers);
        shuffle(baseNumbers);
        List<Integer> lotto = baseNumbers.subList(START, END);
        sort(lotto);

        return Collections.unmodifiableList(lotto);
    }

    private void shuffle(List<Integer> baseNumbers) {
        Collections.shuffle(baseNumbers);
    }

    private void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoNumbers))
            return false;
        LottoNumbers that = (LottoNumbers)o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
