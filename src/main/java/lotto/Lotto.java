package lotto;

import java.util.*;

public class Lotto {

    Set<LottoNumber> lottoNumberList = new HashSet<>();

    public Lotto(List<LottoNumber> lottoNumberList) {
        this.lottoNumberList = new HashSet<>(lottoNumberList);
        if (invalidLottoSet()) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성되어 있어야 합니다.");
        }
    }

    private boolean invalidLottoSet() {
        return lottoNumberList.size() != 6;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumberList=" + lottoNumberList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumberList, lotto.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }

    public int findMatchedLottoNumberCount(Lotto winningLotto) {
        int totalMatchedCount = 0;

        for (LottoNumber lottoNumber : lottoNumberList) {
            if (winningLotto.lottoNumberList.contains(lottoNumber)) {
                totalMatchedCount++;
            }
        }

        return totalMatchedCount;
    }
}