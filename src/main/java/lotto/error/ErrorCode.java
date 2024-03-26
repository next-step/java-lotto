package lotto.error;

public enum ErrorCode {
    // Lotto
    LOTTO_NEEDS_SIX_NUMBERS("로또는 6개의 숫자가 필요합니다."),
    LOTTO_DUPLICATED_NUMBERS("중복되지 않는 번호를 입력해주세요."),
    LOTTO_INVALID_NUMBER("로또는 1부터 45까지의 숫자만 선택할 수 있습니다."),

    // Winning Numbers
    WINNING_NUMBERS_DUPLICATED("보너스 번호는 당첨 번호와 중복될 수 없습니다."),

    // Amount
    AMOUNT_CANNOT_BE_NEGATIVE("수량은 음수가 될 수 없습니다."),

    // Cash
    CASH_CANNOT_BE_NEGATIVE("현금은 마이너스 통장이 아닙니다."),
    CASH_PRICE_CANNOT_BE_BELOW_ZERO("공짜는 없는 세상입니다."),
    CASH_NOT_ENOUGH("현금이 부족합니다."),

    // Rank
    RANK_OVER_MAX_MATCH_COUNT("로또는 그 이상의 당첨이 불가능할텐데요."),
    ;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
