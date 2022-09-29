package lotto.model;

import lotto.service.LottoNumberPicker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Lottos {

    private static final int DEFAULT_RETURN_VALUE = 0;
    private final List<Lotto> lottos;

    public Lottos(int lottoNum, LottoNumberPicker picker) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            this.lottos.add(new Lotto(picker.pick()));
        }
    }

    public Map<MatchNumber, Integer> getMatchNumbers(Lotto winningNumber) {
        return getStreamOfMatchNumberWithMoney(winningNumber)
                .sorted(MatchNumber::compareTo)
                .collect(groupingBy(identity(), LinkedHashMap::new, summingInt(e -> 1)));
    }

    public Integer getWinningMoney(Lotto winningNumber) {
        return getStreamOfMatchNumberWithMoney(winningNumber)
                .map(MatchNumber::getMoney).reduce(Integer::sum).orElse(DEFAULT_RETURN_VALUE);
    }

    private Stream<MatchNumber> getStreamOfMatchNumberWithMoney(Lotto winningNumber) {
        return this.lottos.stream().map((lotto) -> MatchNumber.getMatchNumber(winningNumber.getSameLottoBalls(lotto)))
                .filter(MatchNumber::hasMoney);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return this.lottos.size();
    }
}
