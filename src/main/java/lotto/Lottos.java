/*
* n개의 로또를 지니는 로또 집합 클래스
* */
package lotto;

import java.util.List;
import java.util.Objects;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    /*
    * 보유중인 로또의 당첨 개수를 확인하고, 해당하는 갯수만큼 matches 시켜준다.
    * */
    public void checkWinning(Winning winning) {
        List<Integer> winningNumbers = winning.getWinningNumbers();
        lottoList.forEach(lotto -> {
            winning.matches(lotto.contains(winningNumbers));
        });
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
        StringBuilder stringBuilder = new StringBuilder();
        lottoList.stream().forEach(lotto -> {
                    stringBuilder.append(lotto.toString());
                    stringBuilder.append((System.getProperty("line.separator")));
                });
        return stringBuilder.toString();
    }
}
