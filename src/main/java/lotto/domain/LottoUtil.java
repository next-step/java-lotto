package lotto.domain;

public final class LottoUtil {

    public static double calculateSaveOfReturn(int purchasePrice, long prize) {
        return prize * 1.0 / purchasePrice;
    }
}
