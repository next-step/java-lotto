package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int MAX_LOTTO_RANGE = 45;
    private static final int SINGLE_LOTTO_DIGIT = 6;
    private static final List<LottoNumber> lottoNumPool = initLottoNum();

    public static final int LOTTO_PRICE = 1000;

    private List<LottoNumber> lottoNum;
    private LottoWin lottoWin;

    public Lotto() {
        this.generateLottoNum();
    }

    public List<LottoNumber> lottoNum() {
        return this.lottoNum;
    }

    public LottoWin lottoWin() {
        return lottoWin;
    }


    public void calculateWin(List<LottoNumber> winList, LottoNumber bonusNumber) {
        int matchNum = this.countWin(winList);
        boolean matchBonus = this.lottoNum.contains(bonusNumber);
        this.lottoWin = LottoWin.valueOf(matchNum, matchBonus);
    }

    private int countWin(List<LottoNumber> winList) {
        int winNum = 0;
        for (int i = 0; i < winList.size(); i++) {
            winNum += this.getWinCount(winList.get(i).value());
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

    private static List<LottoNumber> initLottoNum() {
        List<LottoNumber> lottoNumPool = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_RANGE; i++) {
            lottoNumPool.add(new LottoNumber(i));
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
