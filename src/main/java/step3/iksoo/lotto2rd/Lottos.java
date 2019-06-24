package step3.iksoo.lotto2rd;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private List<Lotto> lottos;

    Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Map<Integer, Integer> checkLotteryWin(List<Integer> winnerNumbers) {
        Map<Integer, Integer> map = Stream.of(new Integer[][]{
                {0, 0},
                {1, 0},
                {2, 0},
                {3, 0},
                {4, 0},
                {5, 0},
                {6, 0}
        }).collect(Collectors.toMap(p -> p[0], p -> p[1]));

        this.lottos
                .stream()
                .map(lotto -> lotto.checkNumberOfMatches(winnerNumbers))
                .filter(x -> x >= 3)
                .forEach(x -> map.put(x, map.get(x) + 1));
        return map;
    }

    public double calculateRateProfit(int amoutPrize, int orderPrice) {
        return (double) amoutPrize / orderPrice;
    }
}