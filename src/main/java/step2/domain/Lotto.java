package step2.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public final class Lotto<T> {
    private List<LottoNumbers<T>> lotto = new ArrayList<>();

    public List<LottoNumbers<T>> getLotto() {
        return lotto;
    }

    public void addLottoNumber(LottoNumbers<T> lottoNumbers) {
        this.lotto.add(lottoNumbers);
    }

    public Map<Rank, List<Rank>> getWinLotto(List<T> targetNumbers) {
        return lotto.stream()
                .map(numbers -> Rank.getRank(numbers.getEqualNumberCount(targetNumbers)))
                .filter(r -> r != Rank.MISS)
                .sorted(Comparator.comparingLong(Rank::getCountOfMatch))
                .collect(groupingBy(Function.identity(), toList()));
    }
}
