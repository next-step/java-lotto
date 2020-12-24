package step2.domain.lotto;

import step2.domain.Rank;

import java.util.List;
import java.util.Map;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public class Lotto {
    private final List<LottoNumbers> lotto;
    public static final int LOTTO_PRICE = 1000;

    public Lotto(List<LottoNumbers> lotto) {
        if (lotto == null || lotto.isEmpty()) {
            throw new IllegalArgumentException("로또를 구매해 주세요");
        }
        this.lotto = unmodifiableList(lotto);
    }

    public List<LottoNumbers> getLotto() {
        return unmodifiableList(lotto);
    }

    public Map<Rank, Long> getWinLotto(LottoNumbers targetNumbers, LottoNumber bonusNumber) {
        return getLottoRanks(targetNumbers, bonusNumber).stream()
                .filter(r -> r != Rank.MISS)
                .collect(groupingBy(rank -> rank, counting()));
    }

    List<Rank> getLottoRanks(LottoNumbers targetNumbers, LottoNumber bonusNumber) {
        return lotto.stream()
                .map(numbers -> numbers.getRankOfLottoNumbers(targetNumbers, bonusNumber))
                .collect(toList());
    }
}
