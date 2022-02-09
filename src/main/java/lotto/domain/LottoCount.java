package lotto.domain;

public class LottoCount {

    private static final int LOTTO_COUNT_MINIMUM_VALUE = 0;
    private static final String LOTTO_COUNT_NOT_NUMBER_MESSAGE = "[ERROR] 로또 매수는 숫자만 가능합니다.";
    private static final String LOTTO_COUNT_VALIDATE_MESSAGE = "[ERROR] 로또 매수는 0보다 커야 합니다.";

    private final int lottoCount;

    private LottoCount(int count) {
        this.lottoCount = count;
    }

    public static LottoCount from(Money money) {
        int count = money.getCount();
        return new LottoCount(count);
    }

    public static LottoCount from(String lottoCount) {
        int parsedLottoCount = parseLottoCount(lottoCount);
        validateLottoCount(parsedLottoCount);
        return new LottoCount(parsedLottoCount);
    }

    public int count() {
        return lottoCount;
    }

    public LottoCount minus(LottoCount manualCount) {
        return null;
    }

    private static int parseLottoCount(String lottoCount) {
        try {
            return Integer.parseInt(lottoCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_COUNT_NOT_NUMBER_MESSAGE);
        }
    }

    private static void validateLottoCount(int lottoCount) {
        if (lottoCount <= LOTTO_COUNT_MINIMUM_VALUE) {
            throw new IllegalArgumentException(LOTTO_COUNT_VALIDATE_MESSAGE);
        }
    }
}
