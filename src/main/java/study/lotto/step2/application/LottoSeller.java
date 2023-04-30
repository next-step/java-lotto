package study.lotto.step2.application;

import study.lotto.step2.domain.Lotto;
import study.lotto.step2.domain.LottoFactory;
import study.lotto.step2.domain.SoldLottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoSeller {
    private static final long LOTTO_PRICE = 1_000L;
    private static final String INTEGER_REGEX = "^\\d+$";
    private final LottoFactory lottoFactory;

    public LottoSeller(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public SoldLottos sell(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return sell(Long.parseLong(purchaseAmount));
    }

    public SoldLottos sell(long purchaseAmount) {
        return new SoldLottos(lottos(numberOfSelling(purchaseAmount)));
    }

    private long numberOfSelling(long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / LOTTO_PRICE;
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        if(purchaseAmount == null || !isIntegerExpression(purchaseAmount)) {
            throw new IllegalArgumentException("구입 금액은 양의 정수로 입력해야 합니다: " + purchaseAmount);
        }
    }

    private boolean isIntegerExpression(String purchaseAmount) {
        return purchaseAmount.matches(INTEGER_REGEX);
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if(purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 구입 금액은 " + LOTTO_PRICE + "원입니다: " + purchaseAmount);
        }
    }

    private List<Lotto> lottos(long numberOfLotto) {
        return LongStream.rangeClosed(1, numberOfLotto)
                .mapToObj(index -> lottoFactory.lotto())
                .collect(Collectors.toList());
    }
}
