package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
    public static final int LOTTO_WINNING_MIN_COUNT = 3;

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Map<Rank, Long> getMatchResults(Lotto winnerLotto, LottoBonusNumber lottoBonusNumber) {
        return lottos.stream()
                .map(lotto -> {
                    LottoNumber lottoNumber = lottoBonusNumber.getLottoBonusNumber();
                    boolean matchBonus = lotto.isContains(lottoNumber);
                    int countOfMatch = lotto.matchNumberCounts(winnerLotto);
                    return Rank.valueOf(countOfMatch, matchBonus);
                })
                .filter(rank -> rank != Rank.MISS)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
