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

    public Lotto(List<LottoNumber> lottoNumbers) {
        lottoNum = lottoNumbers;
    }

    public List<LottoNumber> lottoNum() {
        return this.lottoNum;
    }

    public LottoWin lottoWin() {
        return lottoWin;
    }

    public void setLottoWin(LottoWin lottoWin) {
        this.lottoWin = lottoWin;
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
