package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private final List<Lotto> lottoList;
    private final LottoPublisher lottoPublisher;

    public Game(int count) {
        this(count, new RandomLottoPublisher());
    }

    public Game(int count, LottoPublisher lottoPublisher) {
        this.lottoPublisher = lottoPublisher;
        this.lottoList = createLottoList(count);
    }

    private List<Lotto> createLottoList(int count) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(new Lotto(lottoPublisher.get()));
        }
        return result;
    }

    public Map<Integer, Integer> play(List<Integer> winNumbers) {
        Map<Integer, Integer> result = new HashMap<>();
        List<Integer> winCounts = winCounts(winNumbers);
        for (int winCount: winCounts) {
            int count = result.getOrDefault(winCount, 0);
            result.put(winCount, count + 1);
        }
        return result;
    }

    private List<Integer> winCounts(List<Integer> winNumbers) {
        return lottoList.stream()
                .map(lotto -> lotto.matches(winNumbers))
                .collect(Collectors.toList());
    }
}
