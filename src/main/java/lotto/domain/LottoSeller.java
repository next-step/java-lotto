package lotto.domain;

public class LottoSeller {

    public static LottoInput sellLotto(int amount, int manualCount) {
        validateAmount(amount, manualCount);
        int totalCount = amount / Lotto.LOTTO_PRICE;
        int autoCount = totalCount - manualCount;
        return new LottoInput(autoCount, manualCount);
    }

    private static void validateAmount(int amount, int manualCount) {
        if (amount < manualCount * Lotto.LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액보다 많이 살 수 없습니다.");
        }
    }
}
