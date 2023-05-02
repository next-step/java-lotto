package lotto.domain.exception;

public class InvalidLottoMatchingCountException extends LottoException {
    private static final String INVALID_MATCHING_COUNT_ERROR_MESSAGE = "당첨된 번호 갯수는 3~6 사이의 값이어야 합니다.";

    public InvalidLottoMatchingCountException(String... message) {
        super(INVALID_MATCHING_COUNT_ERROR_MESSAGE, message);
    }
}
