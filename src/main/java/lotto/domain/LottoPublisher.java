package lotto.domain;

public class LottoPublisher {

    void validatePurchaseAmount(int amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("투입금액은 0이하의 숫자를 입력할 수 없습니다.");
        }
        if (0 < amount%1000) {
            throw new IllegalArgumentException("투입금액은 1000으로 나누었을때 나머지가 없어야 합니다.");
        }
    }
}
