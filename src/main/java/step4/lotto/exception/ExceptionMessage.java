package step4.lotto.exception;

public class ExceptionMessage {

    private ExceptionMessage() {
    }

    public static final String NUMBER_OUT_OF_BOUNDARY = "로또 넘버는 1~45 사이여야 합니다";
    public static final String INVALID_LOTTO_NUMBER_SIZE = "로또 넘버는 6개 입니다";
    public static final String NUMBER_DUPLICATED = "로또 넘버 사이에 중복이 발생할 수 없습니다";
    public static final String NUMBER_DUPLICATED_BONUS_NUMBER = "보너스 넘버와 로또번호는 중복될 수 없습니다";
    public static final String NOT_ENOUGH_MONEY = "로또 살 돈이 부족합니다";

}
