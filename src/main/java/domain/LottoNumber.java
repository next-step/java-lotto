package domain;

import java.util.ArrayList;
import java.util.Collections;

public class LottoNumber {
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int ONE_UNIT_OF_LOTTO = 6;

    private ArrayList<Integer> lottoElement = null;

    // 생성자를 호출하면 랜덤번호를 생성하여 lottoElement에 로또번호를 추가
    public LottoNumber() {
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

    public ArrayList<Integer> getElement() {
        return lottoElement;
    }

    // 로또 자동 생성 번호와 지난 당첨 번호를 비교
    public int comparePrvNumber(int[] prvLottoNumber) {
        int numofWin = 0;
        for (int i = 0; i < prvLottoNumber.length; ++i) {
            numofWin = lottoElement.contains(prvLottoNumber[i]) ? numofWin + 1 : numofWin;
        }
        return numofWin;
    }
}
