package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.NumberStrategy;

public class WinningLotto extends Lotto {

    public WinningLotto(NumberStrategy numberStrategy) {
        super(numberStrategy);
    }

    public List<Integer> matchCounts(List<Lotto> lottos) {
        return lottos.stream()
            .map(lotto -> matchCount(lotto))
            .collect(Collectors.toList());
    }

    private int matchCount(Lotto lotto) {
        int matchNumber = 0;
        for (int i = 0; i < lotto.getLottoNumber().size(); i++) {
            matchNumber += checkMatch(lotto.getLottoNumber(), i);
        }
        return matchNumber;
    }

    private int checkMatch(List<Integer> lottoNumber, int num) {
        return super.getLottoNumber().contains(lottoNumber.get(num)) ? 1 : 0;
    }


}
