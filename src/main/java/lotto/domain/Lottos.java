package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    public static final int LOTTO_PRICE = 1000;
    public static final int WINNING_STANDARD_NUMBER = 3;
    private final List<Lotto> lottoList;
    private final int lottoCount;

    public Lottos(List<Lotto> lottoList, int lottoCount) {
        this.lottoList = lottoList;
        this.lottoCount = lottoCount;
    }

    public static Lottos of(int lottoPrice) {
        int count = lottoPrice / LOTTO_PRICE;
        return new Lottos(
                Stream.generate(() -> Lotto.createLotto())
                        .limit(count)
                        .collect(Collectors.toList()), count);
    }

    public Map<Integer, Integer> getWinningCount(String[] winningNumbers) {
        Map<Integer, Integer> winningCount = new HashMap<>();
        for (int i = 3; i <= 6; i++) {
            winningCount.put(i, 0);
        }

        lottoList.stream()
                .mapToInt(lotto -> lotto.findSameNumber(winningNumbers))
                .filter(count -> count >= WINNING_STANDARD_NUMBER)
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
