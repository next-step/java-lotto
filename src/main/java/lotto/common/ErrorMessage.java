package lotto.common;

public enum ErrorMessage {
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1~45 까지만 입력이 가능합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("중복된 로또 번호를 입력할 수 없습니다."),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호 6개를 선택해주십시오."),
    NOT_ENOUGH_CASH_PAYMENT("최소 구매금액보다 적어 구매가 불가능합니다.");
    
    private String message;
    
    ErrorMessage(String message) {
        this.message = message;
    }
    
    public String message() {
        return message;
    }
}
