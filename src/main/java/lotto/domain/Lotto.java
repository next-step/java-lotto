package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_GET_NUMBER = 6;
    private static final int ZERO = 0;
    private List<Integer> lottoNumber;
    private List<Integer> allLottoNumber;
    private Integer hitCount;

    public Lotto() {
        CreatableLotto creatableLotto = new LottoFactory().getLottoVersionSix();
        this.allLottoNumber = creatableLotto.makeLotto();
        this.hitCount = ZERO;
        this.lottoNumber = selectLottoNumber(new CreatableLotto() {
            @Override
            public List<Integer> makeLotto() {
                List<Integer> lottoNumbers = new ArrayList<>();
                Collections.shuffle(allLottoNumber);
                for (int i = ZERO; i < LOTTO_GET_NUMBER; i++) {
                    lottoNumbers.add(allLottoNumber.get(i));
                }
                return lottoNumbers;
            }
        });
    }

    public Lotto(List<Integer> lottoNumber) {
        this.hitCount = ZERO;
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> selectLottoNumber(CreatableLotto creatableLotto) {
        return creatableLotto.makeLotto();
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
