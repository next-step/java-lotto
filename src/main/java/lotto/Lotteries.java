package lotto;

import java.util.*;

public class Lotteries {

    Set<Lotto> lottoList = new HashSet<>();

    public Lotteries(List<Lotto> lottoList) {
        this.lottoList = new HashSet<>(lottoList);
        if (invalidLottoSet()) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성되어 있어야 합니다.");
        }
    }

    private boolean invalidLottoSet() {
        return lottoList.size() != 6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotteries lotteries = (Lotteries) o;
        return Objects.equals(lottoList, lotteries.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }
}