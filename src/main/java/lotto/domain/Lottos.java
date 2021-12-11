package lotto.domain;

import lotto.strategy.CreationLottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_RANGE = 0;

    private final List<Lotto> lottos;

    public Lottos(int gameRound, CreationLottoNumber creationLottoNumber) {
        this.lottos = getAutoLotto(gameRound, creationLottoNumber);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Integer> matchCountLotto(Lotto winLotto) {
        return lottos.stream()
                .map(lotto -> lotto.matchCountLottoNumbers(winLotto))
                .filter(matchCount -> matchCount >= 3)
                .collect(Collectors.toList());
    }

    private List<Lotto> getAutoLotto(int gameRound, CreationLottoNumber creationLottoNumber) {
        return IntStream.range(START_RANGE, gameRound)
                .mapToObj(m -> new Lotto(creationLottoNumber))
                .collect(Collectors.toList());
    }

    public List<LottoResult> getResult(Lotto winLotto) {
        return Arrays.stream(Rank.values())
                .map(rank -> new LottoResult(rank, Collections.frequency(matchCountLotto(winLotto), rank.getMatchCount())))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
