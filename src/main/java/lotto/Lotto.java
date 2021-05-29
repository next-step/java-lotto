package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int MAX_LOTTO_RANGE = 45;
    private static final int SINGLE_LOTTO_DIGIT = 6;
    private static final List<Integer> lottoNumPool = initLottoNum();

    public static final int LOTTO_PRICE = 1000;

    private List<Integer> lottoNum;
    private LottoWin lottoWin;

    public Lotto() {
        this.generateLottoNum();
    }

    public List<Integer> lottoNum() {
        return this.lottoNum;
    }

    public LottoWin lottoWin() {
        return lottoWin;
    }


    public void calculateWin(List<Integer> winList) {
        int matchNum = this.countWin(winList);
        if (LottoWin.FIRST_PLACE.matchNum() == matchNum) {
            this.lottoWin = LottoWin.FIRST_PLACE;
            return;
        }
        if (LottoWin.SECOND_PLACE.matchNum() == matchNum) {
            this.lottoWin = LottoWin.SECOND_PLACE;
            return;
        }
        if (LottoWin.THIRD_PLACE.matchNum() == matchNum) {
            this.lottoWin = LottoWin.THIRD_PLACE;
            return;
        }
        if (LottoWin.FOURTH_PLACE.matchNum() == matchNum) {
            this.lottoWin = LottoWin.FOURTH_PLACE;
            return;
        }
        this.lottoWin = LottoWin.LAST_PLACE;
    }

    private int countWin(List<Integer> winList) {
        int winNum = 0;
        for (int i = 0; i < winList.size(); i++) {
            winNum += this.getWinCount(winList.get(i));
        }
        return winNum;
    }

    private int getWinCount(int targetNum) {
        if (this.isWinNumber(targetNum)) {
            return 1;
        }
        return 0;
    }

    private boolean isWinNumber(int targetNum) {
        return this.lottoNum.contains(targetNum);
    }

    private static List<Integer> initLottoNum() {
        List<Integer> lottoNumPool = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_RANGE; i++) {
            lottoNumPool.add(i);
        }
        return lottoNumPool;
    }

    private void generateLottoNum() {
        Collections.shuffle(lottoNumPool);
        lottoNum = new ArrayList<>();
        for (int i = 0; i < SINGLE_LOTTO_DIGIT; i++) {
            lottoNum.add(lottoNumPool.get(i));
        }
    }

}
