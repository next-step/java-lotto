package lotto.domain;

import lotto.strategy.MakeLottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_RANGE = 0;
    private static final int MIN_RANK_NUMBER = 3;
    private final List<Lotto> lottos;

    public Lottos(int gameRound, MakeLottoNumber makeLottoNumber) {
        this.lottos = generateLottos(gameRound, makeLottoNumber);
    }

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    private List<Lotto> generateLottos(int gameRound, MakeLottoNumber makeLottoNumber) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(START_RANGE, gameRound)
                    .forEach(m -> lottos.add(new Lotto(makeLottoNumber)));
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Rank> compareWinLotto(Lotto winLotto) {
        List<Rank> ranks = new ArrayList<>();
        lottos.stream()
                    .map(lotto -> lotto.matchCountLotto(winLotto.getLottoNumbers()))
                    .filter(matchNumber -> matchNumber >= MIN_RANK_NUMBER)
                    .forEach(matchNumber -> ranks.add(Rank.valueOf(matchNumber)));
        return ranks;
    }
}
