package lottogame.domain;

import java.util.List;

public class LottoNumbers {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public LottoNumbers(List<Integer> lottoNumbers) {
        assertLottoNumbers(lottoNumbers);
    }

    private void assertLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                String.format("lottoNumbers의 size는 %d 이여야 합니다. lottoNumbers.size() \"%d\"", LOTTO_NUMBERS_SIZE,
                    lottoNumbers.size()));
        }
    }

}
