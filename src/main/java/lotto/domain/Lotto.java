package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int ZERO = 0;
    private static final int HIT_COUNT = 1;
    private List<LottoNo> lottoNos;

    public Lotto(List<LottoNo> lottoNos) {
        this.lottoNos = Optional.ofNullable(lottoNos)
                .orElse(new LottoFactory().createAutoLotto()
                        .makeLotto());
    }

    public List<LottoNo> getLottoNumber() {
        return this.lottoNos.stream()
                .sorted(Comparator.comparingInt(LottoNo::getNumber))
                .collect(Collectors.toList());
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
        return lottoNos.contains(new LottoNo(winLottoNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNos, lotto.lottoNos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNos);
    }
}
