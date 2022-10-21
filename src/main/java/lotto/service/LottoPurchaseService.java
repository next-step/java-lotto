package lotto.service;

import lotto.domain.Amount;
import lotto.domain.lotto.LottoList;
import lotto.domain.money.ImmutableMoney;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottonumber.LottoNumberSet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPurchaseService {

    public Amount purchaseNumber(final ImmutableMoney immutableMoney) {
        return new Amount(immutableMoney.money().divideValue(Lotto.LOTTO_PRICE.value()).intValue());
    }

    public LottoList purchaseLotto(final Amount amount) {
        return new LottoList(IntStream.range(0, amount.amount())
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList()));
    }

    public LottoList purchaseLotto(final List<LottoNumberSet> lottoNumberSetList) {
        return new LottoList(lottoNumberSetList.stream()
                .map(lottoNumberSet -> new Lotto(lottoNumberSet))
                .collect(Collectors.toList()));
    }
}
