package lotto.domain;

public class LottoCount {

    private static final int LOTTO_COUNT_MINIMUM_VALUE = 0;
    private static final String LOTTO_COUNT_NOT_NUMBER_MESSAGE = "[ERROR] 로또 매수는 숫자만 가능합니다.";
    private static final String LOTTO_COUNT_VALIDATE_MESSAGE = "[ERROR] 로또 매수는 0보다 커야 합니다.";
    private static final String MINUS_EXCEPTION_MESSAGE = "[ERROR] 더 큰 수로 뺄 수 없습니다.";

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

    public LottoCount minus(LottoCount otherCount) {
        if (this.lottoCount < otherCount.lottoCount) {
            throw new IllegalArgumentException(MINUS_EXCEPTION_MESSAGE);
        }
        return new LottoCount(this.lottoCount - otherCount.lottoCount);
    }

    public int count() {
        return lottoCount;
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
