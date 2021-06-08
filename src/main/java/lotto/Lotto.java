package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.LottoNumber.MAX_LOTTO_NUMBER;

public class Lotto {
    private static final int SINGLE_LOTTO_DIGIT = 6;
    private static final List<LottoNumber> lottoNumPool = initLottoNum();

    public static final int LOTTO_PRICE = 1000;

    private List<LottoNumber> lottoNum;
    private LottoWin lottoWin;

    public Lotto() {
        this.generateLottoNum();
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        lottoNum = lottoNumbers;
    }

    public List<LottoNumber> lottoNum() {
        return this.lottoNum;
    }

    public LottoWin lottoWin() {
        return lottoWin;
    }

    public void calculateLottoWin(List<LottoNumber> winList, LottoNumber bonusNumber) {
        this.lottoWin = LottoWinCompare.compareWinning(this, winList, bonusNumber);
    }

    private static List<LottoNumber> initLottoNum() {
        List<LottoNumber> lottoNumPool = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_NUMBER; i++) {
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
