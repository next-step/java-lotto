package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.List;

public class Ranks {

    private final List<Rank> rank;// rateOfProfit을 쓰고 싶은데 그러면 일급 컬렉션이 아니게 된다. 그냥 써도 될까? 아니면 또 하나 더 래핑해야할까?

    public Ranks(List<Rank> rank) {
        this.rank = rank;
    }

    public int countRankOf(Rank first) {
        return (int) rank.stream()
                .filter(first::equals)
                .count();   //실제 서비스에서 페이지 카운트 같은 경우 long인데 int를 잘 안쓰는지??
    }

    public double calculateRateOfProfit() {
        return ((int)(rank.stream()
                .mapToInt(Rank::getPrize)
                .sum() / (rank.size() * 1000d) * 100)) / 100d;
    }

}
