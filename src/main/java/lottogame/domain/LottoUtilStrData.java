package lottogame.domain;

public enum LottoUtilStrData {
    WARNING_STR_LOTTO_MANUAL_COUNT("수량이 잘못입력되었습니다. 다시 실행 후 1이상 숫자를 입력해주세요."),
    WARNING_STR_LOTTO_MANUAL_COUNT_OVER_PRICE("수동로또 구매 수량이 구매가격을 초과하였습니다. 다시 프로그램을 실행해주세요"),
    WARNING_STR_BONUS_NUMBER("보너스볼 번호가 잘못입력되었습니다. 다시 실행 후 올바른 숫자를 입력해주세요."),
    WARNING_STR_LOTTO_NUMBER_COUNT("로또 번호의 입력이 잘못되었습니다. 다시 프로그램을 실행해주세요."),
    WARNING_STR_LOTTO_NUMBER_INPUT("입력한 로또 숫자가 잘못되었습니다. 프로그램을 종료합니다."),
    WARNING_STR_LOTTO_NUMBER_DUPLICATE("입력한 로또 값에 중복이 있습니다. 프로그램을 종료합니다"),
    WARNING_STR_LOTTO_PRICE_LOWER_THN_MINIMUM("최소 금액 1000원 보다 작은 금액이 입력되었습니다. 다시 프로그램을 실행 후 올바른 가격을 입력해주세요."),
    WARNING_STR_WINNINGNUMBER_BONUS_DUPLICATE("로또번호와 보너스 번호가 중복이 됩니다. 프로그램을 종료합니다.");

    private String value;

    LottoUtilStrData(String input) {
        value = input;
    }

    public String getValue() {
        return value;
    }
}
