package lotto.domain;

import java.util.Arrays;

public class Lotto {

    private final int[] lottoNumbers = new int[6];

    private Lotto() {
    }

    public static Lotto of(int[] lottoNumbers) {
        Lotto lotto = new Lotto();
        System.arraycopy(lottoNumbers, 0, lotto.lottoNumbers, 0, 6);
        return lotto;
    }

    public int[] getLottoNumbers() {
        sortLottoNumbers();
        return lottoNumbers;
    }

    private void sortLottoNumbers() {
        Arrays.sort(lottoNumbers);
    }

}
