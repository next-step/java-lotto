package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lottoNumberList;

    public Lotto(List<LottoNumber> lottoNumberList) {

        this.lottoNumberList = lottoNumberList;
    }

    @Override
    public String toString() {
        return lottoNumberList.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(","));
    }

    public int containsCount(List<LottoNumber> lastWeekWinningLotto) {
        return (int) lastWeekWinningLotto.stream()
                .filter(lottoNumberList::contains)
                .count();
    }
}
