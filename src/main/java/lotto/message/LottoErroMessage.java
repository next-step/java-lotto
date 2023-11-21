package lotto.message;

public enum LottoErroMessage {

    NOT_ENOUGH_MONEY("로또 구입 금액은 1000원 이상 입력해야 합니다."),
    NOT_ENOUGH_MONEY_UNIT("로또 구입 금액은 1000원 단위로 가능합니다."),
    NOT_ENOUGH_LOTTO_NUMBER("로또 번호는 6개만 가능합니다."),
    NOT_ENOUGH_LOTTO_NUMBER_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    NOT_ENOUGH_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45까지의 숫자만 가능합니다."),
    NOT_ENOUGH_LOTTO_BONUS_NUMBER("보너스 번호는 로또 번호와 중복될 수 없습니다."),
    OVER_INPUT_MANUAL_COUNT("수동으로 구매할 로또 수는 총 로또 수보다 작아야 합니다.");

    private String message;

    LottoErroMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}
