package lotto.domain;

public enum LottoError {

    SELF_NUMBER_CANNOT_EXCEED_THE_COUNT("L001", "수동 번호 입력 가능 수를 초과했습니다 "),
    MINIMUM_PAYMENT("L002", LottoPolicy.LOTTO_PRICE + "원 이상만 구매할 수 있습니다."),
    WRONG_LOTTO_NUMBER_SIZE("L003", "로또 사이즈는 반드시" + LottoPolicy.LOTTO_SIZE + "이어야 합니다"),
    WRONG_LOTTO_RANGE("L004","로또 사이즈 범위는" + LottoPolicy.LOTTO_MINIMUM_NUMBER + "-" + LottoPolicy.LOTTO_MAXIMUM_NUMBER + "으로 해주십시오");

    private final String code;
    private final String description;

    LottoError(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }
}
