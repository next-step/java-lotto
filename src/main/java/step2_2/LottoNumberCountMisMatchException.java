package step2_2;

public class LottoNumberCountMisMatchException extends RuntimeException {

    private static final String SIZE_MISMATCH_MESSAGE = "로또 숫자는 6개여야 합니다";

    public LottoNumberCountMisMatchException() {
        super(SIZE_MISMATCH_MESSAGE);
    }
}
