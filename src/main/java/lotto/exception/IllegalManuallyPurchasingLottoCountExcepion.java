package lotto.exception;

public class IllegalManuallyPurchasingLottoCountExcepion extends RuntimeException {
    public IllegalManuallyPurchasingLottoCountExcepion() {
        super("수동 구매 로또의 수를 양수로 입력해주세요.");
    }
}
