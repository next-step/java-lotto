package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int ZERO = 0;
    private static final int HIT_COUNT = 1;
    private List<Integer> lottoNumber;

    public Lotto() {
        this.lottoNumber = new LottoNumber().getLottoNumbers();
    }

    public Lotto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> selectLottoNumber(CreatableLotto creatableLotto) {
        return creatableLotto.makeLotto();
    }

    public List<Integer> getLottoNumber() {
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    public int checkWinNumber(int[] winLotto) {
        int hitCount = ZERO;
        for (int lotto : winLotto) {
            hitCount += getHitCount(lotto);
        }
        return hitCount;
    }

    public int getHitCount(int winLottoNumber) {
        if (isContainsWinNumber(winLottoNumber)) {
            return HIT_COUNT;
        } else return ZERO;
    }

    public boolean isContainsWinNumber(int winLottoNumber) {
        return lottoNumber.contains(winLottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumber, lotto.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
