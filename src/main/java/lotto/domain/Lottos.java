/*
* n개의 로또를 지니는 로또 집합 클래스
* */
package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    /*
    * 보유중인 로또의 당첨 개수를 확인하고, 해당하는 갯수만큼 matches 시켜준다.
    * */
    public List<Rank> checkWinning(WinningNumbers winningNumbers) {
        return lottoList.stream()
                .map(lotto -> winningNumbers.matches(lotto))
                .collect(Collectors.toList());
    }

    public int getBuyNum() {
        return lottoList.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return lottoList.containsAll(lottos.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(lottoList.toString())
                .toString();
    }
}
