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
        for (int i = 3; i <= 6; i++) {
            winningCount.put(i, 0);
        }

        lottoList.stream()
                .mapToInt(lotto -> lotto.findSameNumber(winningNumbers))
                .filter(count -> count >= 3)
                .forEach(count -> {
                    Integer temp = winningCount.get(count) + 1;
                    winningCount.replace(count, temp);
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
