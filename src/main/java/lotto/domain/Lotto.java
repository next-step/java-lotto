package lotto.domain;

import java.util.Arrays;

public class Lotto {
    public static final int LOTTO_UNIT_NUMBER = 6;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final Integer[][] lottoNumber;

    public Lotto(int lottoOfNumber) {
        this.lottoNumber = new Integer[lottoOfNumber][LOTTO_UNIT_NUMBER];
        for (int i = 0; i < lottoOfNumber; i++) {
            generateLottoRow(i);
        }
    }

    private void generateLottoRow(int rowIndex) {
        for (int i = 0; i < LOTTO_UNIT_NUMBER; i++) {
            lottoNumber[rowIndex][i] = ((int) (Math.random() * LOTTO_MAX_NUMBER)) + 1;
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(lottoNumber);
    }
}
