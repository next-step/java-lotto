package lotto.domain;

public class LottoCount {
    private static final String ERROR_MANUAL_COUNT_EXCEEDS_TOTAL = "수동으로 구매한 로또 개수가 총 개수를 초과할 수 없습니다.";
    private static final String ERROR_AUTO_COUNT_NEGATIVE = "자동으로 구매한 로또 개수는 음수일 수 없습니다.";
    private static final String ERROR_MANUAL_COUNT_NEGATIVE = "수동으로 구매한 로또 개수는 음수일 수 없습니다.";
    public static final int LOTTO_MINIMUM_COUNT = 0;
    private final int totalCount;
    private final int autoCount;
    private final int manualCount;

    public LottoCount(LottoPrice lottoPrice, int manualCount) {
        this(calculateLottoCount(lottoPrice), calculateAutoLottoCount(lottoPrice, manualCount), manualCount);
    }

    public LottoCount(int totalCount, int autoCount, int manualCount) {
        validateCounts(totalCount, autoCount, manualCount);
        this.totalCount = totalCount;
        this.autoCount = autoCount;
        this.manualCount = manualCount;
    }

    private static int calculateLottoCount(LottoPrice lottoPrice) {
        return lottoPrice.getGameMoney() / LottoPrice.GAME_PRICE;
    }

    private static int calculateAutoLottoCount(LottoPrice lottoPrice, int manualCount) {
        return calculateLottoCount(lottoPrice) - manualCount;
    }

    private void validateCounts(int totalCount, int autoCount, int manualCount) {
        if (manualCount > totalCount) {
            throw new IllegalArgumentException(ERROR_MANUAL_COUNT_EXCEEDS_TOTAL);
        }
        if (manualCount < LOTTO_MINIMUM_COUNT) {
            throw new IllegalArgumentException(ERROR_MANUAL_COUNT_NEGATIVE);
        }
        if (autoCount < LOTTO_MINIMUM_COUNT) {
            throw new IllegalArgumentException(ERROR_AUTO_COUNT_NEGATIVE);
        }
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
