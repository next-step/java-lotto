package lotto.domain;

import lotto.strategy.CreationLottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_RANGE = 0;
    private static final int MIN_RANK_MATCH_COUNT = 3;

    private final List<Lotto> lottos;

    public Lottos(int gameRound, CreationLottoNumber creationLottoNumber) {
        this.lottos = getAutoLotto(gameRound, creationLottoNumber);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> getAutoLotto(int gameRound, CreationLottoNumber creationLottoNumber) {
        return IntStream.range(START_RANGE, gameRound)
                .mapToObj(m -> Lotto.getAutoLotto(creationLottoNumber))
                .collect(Collectors.toList());
    }

    public List<LottoResult> getResult(PrizeLotto prizeLotto) {
        return Arrays.stream(Rank.values())
                .map(rank -> new LottoResult(rank, Collections.frequency(lottoRanks(prizeLotto), rank)))
                .collect(Collectors.toList());
    }

    private List<Rank> lottoRanks(PrizeLotto prizeLotto) {
        return lottos.stream()
                .filter(lotto -> lotto.matchCountLottoNumbers(prizeLotto) >= MIN_RANK_MATCH_COUNT)
                .map(lotto -> Rank.valueOf(lotto.matchCountLottoNumbers(prizeLotto), prizeLotto.matchBonusNumber(lotto)))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
