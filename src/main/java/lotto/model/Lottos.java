package lotto.model;

import lotto.service.LottoNumberPicker;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

public class Lottos {

    private static final int DEFAULT_RETURN_VALUE = 0;
    private final List<Lotto> lottos;

    public Lottos(int lottoNum, LottoNumberPicker picker) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> lotto = picker.pick();
            this.lottos.add(new Lotto(lotto));
        }
    }

    public Map<MatchNumber,Long> getMatchNumbers(Lotto winningNumber) {
        return getStreamOfMatchNumberWithMoney(winningNumber)
                .sorted(Comparator.comparing(MatchNumber::getCount))
                .collect(groupingBy(identity(),LinkedHashMap::new,counting()));
    }

    public Integer getWinningMoney(Lotto winningNumber){
        return getStreamOfMatchNumberWithMoney(winningNumber)
                .map(MatchNumber::getMoney).reduce(Integer::sum).orElse(DEFAULT_RETURN_VALUE);
    }

    private Stream<MatchNumber> getStreamOfMatchNumberWithMoney(Lotto winningNumber) {
        return this.lottos.stream().map((lotto) -> MatchNumber.getMatchNumber(lotto.getMatchedCount(winningNumber)))
                .filter(MatchNumber::hasMoney);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getSize() {
        return this.lottos.size();
    }
}
