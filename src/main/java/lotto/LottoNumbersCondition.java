package lotto;

import java.util.Set;

public class LottoNumbersCondition {
    private static final int DEFAULT_MIN_LOTTO_NUMBER = 1;
    private static final int DEFAULT_MAX_LOTTO_NUMBER = 45;
    private static final int DEFAULT_LOTTO_NUMBER_SIZE = 6;

    private final int minLottoNumber;
    private final int maxLottoNumber;
    private final int lottoNumberSize;

    private static final LottoNumbersCondition DEFAULT_INSTANCE = new LottoNumbersCondition(DEFAULT_MIN_LOTTO_NUMBER, DEFAULT_MAX_LOTTO_NUMBER, DEFAULT_LOTTO_NUMBER_SIZE);

    public LottoNumbersCondition(int minLottoNumber, int maxLottoNumber, int lottoNumberSize) {
        this.minLottoNumber = minLottoNumber;
        this.maxLottoNumber = maxLottoNumber;
        this.lottoNumberSize = lottoNumberSize;
    }

    public static LottoNumbersCondition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public void isNumberValid(Set<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(num -> num < minLottoNumber || num > maxLottoNumber)) {
            throw new IllegalArgumentException("Lotto requires a number between 1 and " + maxLottoNumber);
        }
    }

    public void isSizeValid(Set<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != lottoNumberSize) {
            throw new IllegalArgumentException("Lotto requires " + lottoNumberSize + " numbers.");
        }
    }

    public int getMinLottoNumber() {
        return minLottoNumber;
    }

    public int getMaxLottoNumber() {
        return maxLottoNumber;
    }

    public int getLottoNumberSize() {
        return lottoNumberSize;
    }
}
