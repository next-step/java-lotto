package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotteries {

    List<Lotto> lottoList = new ArrayList<>();

    public Lotteries(List<Lotto> lottoList) {
        // TODO : 1장의 로또는 6개의 번호를 가지고 있어야 하며, 중복이 없어야 함. [정렬도 되어 있어야 해]
        this.lottoList = lottoList;
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