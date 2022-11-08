package lotto.models.request;

import java.util.List;

public class IssueLottoRequest {
    private final int payment;
    private final List<String> manualLottoNumbers;

    private IssueLottoRequest(int payment, List<String> manualLottoNumbers) {
        this.payment = payment;
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public int getPayment() {
        return payment;
    }

    public List<String> getManualLottoNumbers() {
        return manualLottoNumbers;
    }

    public static IssueLottoRequest of(int payment, List<String> manualLottoNumbers) {
        return new IssueLottoRequest(payment, manualLottoNumbers);
    }
}
