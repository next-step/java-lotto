package step2.domain.lotto;

import step2.domain.Rank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public final class Lotto {
    private List<LottoNumbers> lotto = new ArrayList<>();

    public List<LottoNumbers> getLotto() {
        return unmodifiableList(lotto);
    }

    public void addLottoNumber(LottoNumbers lottoNumbers) {
        this.lotto.add(lottoNumbers);
    }

    public Map<Rank, List<Rank>> getWinLotto(List<Integer> targetNumbers) {
        return getLottoRanks(targetNumbers).stream()
                .filter(r -> r != Rank.MISS)
                .sorted(Comparator.comparingLong(Rank::getCountOfMatch))
                .collect(groupingBy(rank -> rank, toList()));
    }

    List<Rank> getLottoRanks(List<Integer> targetNumbers) {
        return lotto.stream()
                .map(numbers -> Rank.getRank(numbers.getEqualNumberCount(targetNumbers)))
                .collect(toList());
    }
}
