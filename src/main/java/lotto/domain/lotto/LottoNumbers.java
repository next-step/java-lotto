package lotto.domain.lotto;

import java.util.*;

public class LottoNumbers {
    public static final int START_LOTTO_RANGE = 0;
    public static final int END_LOTTO_RANGE = 6;
    private static final Numbers numbers = new Numbers();

    private List<Integer> lottoNumbers;

    public LottoNumbers() {
        List<Integer> lottoNumbers = createLottoNumbers();
        checkSize(lottoNumbers);
        checkDuplicate(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    private List<Integer> createLottoNumbers() {
        Collections.shuffle(getNumbers(numbers));
        List<Integer> lottoNumbers = new ArrayList<>(getNumbers(numbers).subList(START_LOTTO_RANGE, END_LOTTO_RANGE));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != END_LOTTO_RANGE) {
            throw new IllegalArgumentException("당첨 번호는" + END_LOTTO_RANGE + "개 입니다");
        }
    }

    private void checkDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }

    private List<Integer> getNumbers(Numbers numbers) {
        return numbers.getNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }


}
