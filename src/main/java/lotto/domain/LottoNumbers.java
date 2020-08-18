package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LottoNumbers {

    public static final int LOTTO_BASE_START_NUMBER = 1;
    public static final int LOTTO_BASE_END_NUMBER = 45;
    public static final String INVALID_LOTTO_NUMBER = "유효하지 않은 번호입니다.";

    private List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
        this.lottoNumbers = initLottoNumbers(lottoNumbers);
        Collections.shuffle(this.lottoNumbers);
    }

    private List<Integer> initLottoNumbers(List<Integer> lottoNumbers) {
        for (int i = LOTTO_BASE_START_NUMBER; i <= LOTTO_BASE_END_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }

    public void lottoNumberRangeException(LottoNumbers lottoNumbers) {
        for (int number : lottoNumbers.lottoNumbers) {
            lottoNumberRangeCheck(number);
        }
    }

    private void lottoNumberRangeCheck(int number) {
        if (number < LOTTO_BASE_END_NUMBER || number < LOTTO_BASE_START_NUMBER) {
            throw new RuntimeException(INVALID_LOTTO_NUMBER);
        }
    }

    public Stream<Integer> getLottoNumbers() {
        return lottoNumbers.stream();
    }

    public long count() {
        return lottoNumbers.stream()
                .count();
    }

}
