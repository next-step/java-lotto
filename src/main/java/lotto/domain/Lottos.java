package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottoList;
    private final int lottoCount;

    public Lottos(List<Lotto> lottoList, int lottoCount) {
        this.lottoList = lottoList;
        this.lottoCount = lottoCount;
    }

    public static Lottos of(int lottoPrice) {
        int count = lottoPrice / 1000;
        return new Lottos(
                Stream.generate(() -> Lotto.createLotto())
                        .limit(count)
                        .collect(Collectors.toList()), count);
    }

    public Map<Integer, Integer> getWinningCount(String[] winningNumbers) {
        Map<Integer, Integer> winningCount = new HashMap<Integer, Integer>();
        winningCount.put(3, 0);
        winningCount.put(4, 0);
        winningCount.put(5, 0);
        winningCount.put(6, 0);

        lottoList.stream()
                .mapToInt(lotto -> lotto.findSameNumber(winningNumbers))
                .forEach(count -> {
                    if (count >= 3) {
                        Integer temp = winningCount.get(count) + 1;
                        winningCount.replace(count, temp);
                    }
                });

        return winningCount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
