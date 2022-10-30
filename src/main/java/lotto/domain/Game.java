package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private final List<Lotto> lottos;
    private final LottoPublisher lottoPublisher;

    public Game(int count, LottoPublisher lottoPublisher) {
        this.lottoPublisher = lottoPublisher;
        this.lottos = createLottoList(count);
    }

    private List<Lotto> createLottoList(int count) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(new Lotto(lottoPublisher.get()));
        }
        return result;
    }

    public Map<Prize, Integer> play(Lotto winNumbers, int bonusNumber) {
        Map<Prize, Integer> result = new HashMap<>();
        List<Prize> prizes = winPrizes(winNumbers, bonusNumber);
        for (Prize prize: prizes) {
            int count = result.getOrDefault(prize, 0);
            result.put(prize, count + 1);
        }
        return result;
    }

    private List<Prize> winPrizes(Lotto winNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.matches(winNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
