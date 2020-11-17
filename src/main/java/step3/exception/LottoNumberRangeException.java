package step3.exception;

public class LottoNumberRangeException extends IllegalArgumentException {
    public LottoNumberRangeException() {
        super("로또 번호들은 제한된 범위에서 넘을수 없습니다.");
    }
}
