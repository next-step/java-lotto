package lotto.exception;

public class LottoSizeOrDuplicateException extends RuntimeException {
    private static final String LOTTO_SIZE_EXCEPTION_MSG = "중복 번호가 있거나 번호가 %d개가 아닙니다.";

    public LottoSizeOrDuplicateException(int lottoSize) {
        System.out.printf(LOTTO_SIZE_EXCEPTION_MSG, lottoSize);
    }
}
