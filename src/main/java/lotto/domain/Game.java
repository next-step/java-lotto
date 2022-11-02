package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    private final List<Lotto> lottos;
    private final LottoPublisher lottoPublisher;

    public Game(int count, List<Lotto> selfLottos, LottoPublisher lottoPublisher) {
        this.lottoPublisher = lottoPublisher;
        int autoLottoCount = count - selfLottos.size();
        this.lottos = Stream.concat(selfLottos.stream(), createLottoList(autoLottoCount).stream())
                .collect(Collectors.toList());
    }

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

    public LottoResult play(Lotto winNumbers, int bonusNumber) {
        List<Prize> prizes = winPrizes(winNumbers, bonusNumber);
        return new LottoResult(prizes);
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
