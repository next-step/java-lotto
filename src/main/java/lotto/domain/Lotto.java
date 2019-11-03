package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_GET_NUMBER = 6;
    private static final int ZERO = 0;
    private static List<Integer> allLottoNumber;
    private List<Integer> lottoNumber;
    private Integer hitCount;

    static {
        allLottoNumber = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            allLottoNumber.add(i);
        }
    }

    public Lotto() {
        this.lottoNumber = new ArrayList<>();
        this.hitCount = ZERO;
    }

    public void selectLottoNumber() {
        Collections.shuffle(allLottoNumber);
        for (int i = ZERO; i < LOTTO_GET_NUMBER; i++) {
            this.lottoNumber.add(allLottoNumber.get(i));
        }
    }

    void checkNumber(int[] winLotto) {
        for (int i = ZERO; i < winLotto.length; i++) {
            hit(winLotto[i]);
        }
    }

    private void hit(Integer winLotto) {
        if (lottoNumber.contains(winLotto)) {
            this.hitCount++;
        }
    }

    public Integer getHitCount() {
        return hitCount;
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
}
