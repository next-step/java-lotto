package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotteries {

    List<Lotto> lottoList = new ArrayList<>();

    public Lotteries(List<Lotto> lottoList) {
        if (invalidLottoSet(lottoList)) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성되어 있어야 합니다.");
        }
        this.lottoList = lottoList;
    }

    private boolean invalidLottoSet(List<Lotto> lottoList) {
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