package lottery.domain;

public class ErrorMessages {

    public static final String PURCHASE_PRICE_NOT_ENOUGH = "Error : 로또 티켓 구매 금액이 부족합니다.";
    public static final String OUT_OF_RANGE = "Error : 로또 번호는 1부터 45 사이의 숫자만 가능합니다.";
    public static final String INVALID_NUMBER_COUNTS = "Error : 로또 티켓은 총 6개의 번호로 이루어져 있습니다.";
    public static final String DUPLICATED_NUMBER = "Error : 로또 티켓의 번호들은 중복될 수 없습니다.";
    public static final String INVALID_MATCH_NUMBER_COUNTS = "Error : 정의 되지 않은 당첨 번호 개수입니다.";
    public static final String INVALID_BONUS_BALL_NUMBER = "Error : 보너스 번호는 당첨 티켓 번호와 중복될 수 없ㅅ브니다.";
    public static final String INVALID_BONUS_BALL_COUNT = "Error : 보너스 번호를 2개 이상 가질 수 없습니다.";

    private ErrorMessages() {
    }
}
