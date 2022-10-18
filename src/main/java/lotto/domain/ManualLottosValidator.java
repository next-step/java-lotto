package lotto.domain;

public class ManualLottosValidator {

    private ManualLottosValidator() {}

    public static void validate(final int countOfTotalLotto, final int countOfManualLotto) {

        if (countOfTotalLotto < countOfManualLotto) {
            throw new IllegalArgumentException("지불한 금액보다 수동으로 구입하려는 로또가 더 많습니다.");
        }
        if (countOfTotalLotto != countOfManualLotto) {
            throw new IllegalArgumentException("수동 구매한 로또수와 수동 로또 입력값이 맞지 않습니다.");
        }
    }
}
