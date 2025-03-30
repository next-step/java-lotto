package lotto.domain;

import common.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    private static final Money LOTTO_PRICE = new Money(1000);

    public LottoPurchase purchase(Money purchaseAmount, List<List<Integer>> lottoManualNumbers) {
        Money amountForManual = getAmountForManual(purchaseAmount, lottoManualNumbers.size());
        Money amountForAuto = purchaseAmount.sub(amountForManual);

        Pair<Money> pair = amountForAuto.divAndMod(LOTTO_PRICE);
        Money change = pair.getRight();
        int autoSize = pair.getLeft().getValue();

        List<Lotto> lottos = createLottos(autoSize, lottoManualNumbers);

        return new LottoPurchase(purchaseAmount, change, lottos, lottoManualNumbers.size());
    }

    private List<Lotto> createLottos(int autoLottoSize, List<List<Integer>> lottoManualNumbers) {
        List<Lotto> result = new ArrayList<>();
        result.addAll(createManualLottos(lottoManualNumbers));
        result.addAll(createAutoLottos(autoLottoSize));
        return result;
    }

    private List<Lotto> createManualLottos(List<List<Integer>> lottoManualNumbers) {
        return lottoManualNumbers
                .stream()
                .map(LottoFactory::createManual)
                .collect(Collectors.toList());
    }

    private List<Lotto> createAutoLottos(int lottoSize) {
        return IntStream.range(0, lottoSize)
                .mapToObj(i -> LottoFactory.createAuto())
                .collect(Collectors.toList());
    }

    private Money getAmountForManual(Money purchaseAmount, int manualSize) {
        Money amountForManual = new Money(manualSize).mul(LOTTO_PRICE);

        if (purchaseAmount.compareTo(amountForManual) < 0) {
            throw new IllegalArgumentException("구입금액보다 수동구입금액이 큽니다.");
        }

        return amountForManual;
    }

}
