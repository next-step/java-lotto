package lotto.exception;

public class NotFoundRankException extends RuntimeException {

    private static final String MESSAGE = "일치하는 개수(%d개)에 해당하는 Rank를 찾을수 없습니다.";

    public NotFoundRankException(int matchCount) {
        super(String.format(MESSAGE, matchCount));
    }
}
