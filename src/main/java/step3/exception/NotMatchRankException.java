package step3.exception;

public class NotMatchRankException extends IllegalArgumentException {


    private static final String LOTTO_RANK_NOT_MATCH_EXCEPTION = "맞춘 갯수가 부정확 합니다.";

    public NotMatchRankException() {
        super(LOTTO_RANK_NOT_MATCH_EXCEPTION);
    }
}
