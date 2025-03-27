package lotto.view.fake;


import lotto.domain.PaymentReceipt;
import lotto.domain.product.LotteryTicket;
import lotto.view.input.BaseInputView;

public class FakeInputView extends BaseInputView {

    private final String input;

    public FakeInputView(String input) {
        this.input = input;
    }

    @Override
    public String read() {
        return input.trim();
    }

    @Override
    public PaymentReceipt purchase() {
        return new PaymentReceipt(input);
    }

    @Override
    public void closeScanner() {}

    @Override
    public LotteryTicket lastWeekNumber() {
        return new LotteryTicket(parseToLottoNumbers(input));
    }

    public Integer parseInt() {
        return Integer.parseInt(this.input);
    }
}
