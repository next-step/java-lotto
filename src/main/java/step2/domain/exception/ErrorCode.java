package step2.domain.exception;

public enum ErrorCode {
    INVALID_LOTTO_NUMBER("L001", "Lotto Number Not In 1~45 Boundary"),
    INVALID_NUMBER_OF_LOTTO_BALLS("L002", "Lotto Balls Not In 1~45 Boundary"),
    NOT_ENOUGH_MONEY("L003", "Not Enough Money"),
    DUPLICATED_OR_ABNORMAL_NUMBER_OF_LOTTO_BALLS("L004", "Lotto Balls Are Either Duplicated Or Abnormally Generated"),
    INVALID_WINNING_LOTTO_NUMBERS("L005", "Invalid Winning Lotto Balls"),

    NEGATIVE_MONEY_AMOUNT("M001", "Negative Money Amount Is Not Allowed");

    private final String code;
    private final String message;

    ErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
