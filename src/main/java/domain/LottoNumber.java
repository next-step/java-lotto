package domain;

import java.util.ArrayList;
import java.util.Collections;

public class LottoNumber {
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int ONE_UNIT_OF_LOTTO = 6;

    private ArrayList<Integer> lottoElement = null;

    public LottoNumber() {
        getLottoElementNumber();
    }

    public ArrayList<Integer> getElement() {
        return lottoElement;
    }

    public void getLottoElementNumber() {
        ArrayList<Integer> randomNumber = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_NUMBER; i++) {
            randomNumber.add(i);
        }

        Collections.shuffle(randomNumber);

        lottoElement = new ArrayList<>();
        for (int i = 0; i < ONE_UNIT_OF_LOTTO; i++) {
            lottoElement.add(randomNumber.get(i));
        }
    }

    public int comparePrvNumber(int[] prvLottoNumber) {
        int numofWin = 0;
        for (int i = 0; i < prvLottoNumber.length; ++i) {
            numofWin = lottoElement.contains(prvLottoNumber[i]) ? numofWin + 1 : numofWin;
        }
        return numofWin;
    }
}
