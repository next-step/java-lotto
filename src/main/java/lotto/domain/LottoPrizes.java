package lotto.domain;

import java.util.List;

import static lotto.domain.LottoVendingMachine.PRICE;

public class LottoPrizes {
    private final List<LottoPrize> lottoPrizes;

    public LottoPrizes(List<LottoPrize> lottoPrizes) {
        validate(lottoPrizes);
        this.lottoPrizes = lottoPrizes;
    }

    private void validate(List<LottoPrize> lottoPrizes) {
        if (lottoPrizes == null || lottoPrizes.isEmpty()) {
            throw new IllegalArgumentException("lottoPrizes는 빈 값일 수 없습니다.");
        }
    }

    public List<LottoPrize> getLottoPrizes() {
        return lottoPrizes;
    }

    public Amount prizeAmount() {
        return new Amount(lottoPrizes.stream()
                .mapToLong(lottoPrizes -> lottoPrizes.getAmount().getValue())
                .sum());
    }

    public Amount purchaseAmount() {
        return new Amount((long) lottoPrizes.size() * PRICE);
    }
}
