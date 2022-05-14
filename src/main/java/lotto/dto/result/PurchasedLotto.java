package lotto.dto.result;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLotto {

    private List<Integer> lottoNumbers;

    public PurchasedLotto(Lotto lotto) {
        this.lottoNumbers = lotto.lottoNumbers()
                .toList()
                .stream()
                .map(LottoNumber::toInt)
                .collect(Collectors.toList());
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers;
    }
}
