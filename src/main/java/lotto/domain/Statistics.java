package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistics {

    private final Lotto winningLotto;
    private final List<Lotto> lottos;
    private final Map<Rank, Integer> lottoRank = new HashMap<>();

    public Statistics(List<Lotto> lottos, String winningLottoNumbers) {
        this.lottos = lottos;
        List<Integer> winningLotto = Arrays.stream(winningLottoNumbers.split(","))
                                            .map(num -> Integer.parseInt(num))
                                            .collect(Collectors.toList());
        this.winningLotto = new Lotto(winningLotto);
    }

    public Map<Rank, Integer> getStatistics() {
        Arrays.stream(Rank.values())
                .forEach(prize -> lottoRank.put(prize, Rank.countMatchlottos(prize, lottos, winningLotto)));

        return lottoRank;
    }

}
