package lotto.model;

import lotto.service.LottoNumberPicker;
import lotto.service.RandomNumberGenerator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Lottos {

    private static final int DEFAULT_RETURN_VALUE = 0;
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos getRandomLottos(int lottoNum) {
        return new Lottos(IntStream.range(0, lottoNum)
                .mapToObj((idx) -> new Lotto(LottoNumberPicker.pick(RandomNumberGenerator.generate())))
                .collect(Collectors.toList()));
    }

    public static Lottos getManualLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Map<MatchNumber, Integer> getMatchNumbers(WinningLotto winningLotto) {
        return getStreamOfMatchNumberWithMoney(winningLotto)
                .sorted(MatchNumber::compareTo)
                .collect(groupingBy(identity(), LinkedHashMap::new, summingInt(e -> 1)));
    }

    public Integer getWinningMoney(WinningLotto winningLotto) {
        return getStreamOfMatchNumberWithMoney(winningLotto)
                .map(MatchNumber::getMoney).reduce(Integer::sum).orElse(DEFAULT_RETURN_VALUE);
    }

    private Stream<MatchNumber> getStreamOfMatchNumberWithMoney(WinningLotto winningLotto) {
        return this.lottos.stream().map((lotto) -> {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean hasBonusBall = winningLotto.hasBonusBall(lotto);
            return MatchNumber.getMatchNumber(matchCount, hasBonusBall);
        });
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return this.lottos.size();
    }

    public void add(Lottos lottos) {
        this.lottos.addAll(lottos.lottos);
    }

}
