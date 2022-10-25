package lotto.validator;

import lotto.models.IssuedLotto;
import lotto.models.request.IssueLottoRequest;

public class IssueLottoRequestValidator {

    private static final String WRONG_PAYMENT = "지불한 금액은 1원 이상 이어야 합니다.";
    private static final String INSUFFICIENT_AMOUNT = "수동 번호를 입력한 개수보다 지불한 금액으로 살 수 있는 로또 수가 적습니다.";

    public static void validate(IssueLottoRequest issueLottoRequest) {
        int payment = issueLottoRequest.getPayment();
        if (payment <= 0) {
            throw new IllegalArgumentException(WRONG_PAYMENT);
        }

        int possibleIssueCount = payment / IssuedLotto.PRICE;
        if (possibleIssueCount < issueLottoRequest.getManualLottoNumbers().size()) {
            throw new IllegalArgumentException(INSUFFICIENT_AMOUNT);
        }
    }
}
