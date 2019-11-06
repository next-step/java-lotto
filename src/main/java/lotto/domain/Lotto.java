package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_GET_NUMBER = 6;
    private static final int ZERO = 0;
    private List<Integer> lottoNumber;
    private List<Integer> allLottoNumber;

    public Lotto() {
        CreatableLotto creatableLotto = new LottoFactory().getLottoVersionSix();
        this.allLottoNumber = creatableLotto.makeLotto();
        this.lottoNumber = selectLottoNumber(() -> {
            List<Integer> lottoNumbers = new ArrayList<>();
            Collections.shuffle(allLottoNumber);
            for (int i = ZERO; i < LOTTO_GET_NUMBER; i++) {
                lottoNumbers.add(allLottoNumber.get(i));
            }
            return lottoNumbers;
        });
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

    public int checkWinNumber(int[] winLotto) {
        int hitCount = 0;
        for (int lotto : winLotto) {
            hitCount += getHitCount(lotto);
        }
        return hitCount;
    }

    public int getHitCount(int winLottoNumber) {
        if (isContainsWinNumber(winLottoNumber)) {
            return 1;
        } else return 0;
    }

    public boolean isContainsWinNumber(int winLottoNumber) {
        return lottoNumber.contains(winLottoNumber);
    }
}
