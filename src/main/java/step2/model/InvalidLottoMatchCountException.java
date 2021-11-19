package step2.model;

public class InvalidLottoMatchCountException extends RuntimeException{

    private static final String ERROR_MESSAGE = "당첨은 최소 3개에서 최대 6개까지 일치해야 합니다";

    public InvalidLottoMatchCountException() {
        super(ERROR_MESSAGE);
    }
}
