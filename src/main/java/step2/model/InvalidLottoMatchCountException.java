package step2.model;

public class InvalidLottoMatchCountException extends RuntimeException{

    private static final String ERROR_MESSAGE = "일치하는 숫자는 0개 이상 6개 이하여야 합니다";

    public InvalidLottoMatchCountException() {
        super(ERROR_MESSAGE);
    }
}
