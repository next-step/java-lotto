package lotto.domain;

public final class LottoUtil {

    public static double calculateSaveOfReturn(int purchasePrice, int prize) {
        return prize * 1.0 / purchasePrice;
    }
}
