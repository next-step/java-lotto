package lotto.exception;

public class WinnerUndefinedException extends RuntimeException{
    public WinnerUndefinedException() {
        throw new RuntimeException("당첨티켓이 집계 읺았거나, 당첨번호가 입력되지 않았습니다");
    }
}
