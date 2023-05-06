package lotto.exception;

public class NotKindOfLottoNumberException extends IllegalArgumentException {
    public NotKindOfLottoNumberException(char token) {
        super(String.format("LottoNumber 로 변환할 수 없는 문자 [%c] 가 입력되었습니다", token));
    }
}
