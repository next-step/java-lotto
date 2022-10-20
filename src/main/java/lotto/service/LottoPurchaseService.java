package lotto.service;

import lotto.domain.Amount;
import lotto.domain.Money.ImmutableMoney;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottonumber.LottoNumberSet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPurchaseService {

    public Amount purchaseNumber(final ImmutableMoney immutableMoney) {
        return new Amount(immutableMoney.money().divideValue(Lotto.LOTTO_PRICE.value()).intValue());
    }

    public List<Lotto> purchaseLotto(final Amount amount) {
        return IntStream.range(0, amount.amount())
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }

    public List<Lotto> purchaseLotto(final List<LottoNumberSet> lottoNumberSetList) {
        return lottoNumberSetList.stream()
                .map(lottoNumberSet -> new Lotto(lottoNumberSet))
                .collect(Collectors.toList());
    }
}
