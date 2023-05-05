package lotto.domain;

import lotto.utile.Deduplicator;
import lotto.utile.RandomNumberGenerator;
import lotto.utile.SortNumber;

public class Lotto {
    int[] lottoNumber;
    private final int LOTTO_NUMBER_COUNT = 6;

    public Lotto() {
        this.lottoNumber = createLottoNumber();
    }

    private int[] createLottoNumber() {
        int[] arrLottoNumber = new int[LOTTO_NUMBER_COUNT];
        for (int i = 0; i < arrLottoNumber.length; i++) {
            int randomNumber = RandomNumberGenerator.getRandomNumber();
            //번호 중복 시, i--
            i = i + Deduplicator.checkDuplication(arrLottoNumber, randomNumber);

            arrLottoNumber[i] = randomNumber;
        }
        SortNumber.sortArrayNumber(arrLottoNumber);
        return arrLottoNumber;
    }

    public int[] getLottoNumber() {
        return lottoNumber;
    }
}
