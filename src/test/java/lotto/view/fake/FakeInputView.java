package lotto.view.fake;


import lotto.domain.PaymentReceipt;
import lotto.domain.product.LotteryTicket;
import lotto.domain.product.LottoNumber;
import lotto.domain.product.WinningTicket;
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
    public WinningTicket getWinningTicket() {
        return new WinningTicket(new LotteryTicket(parseToLottoNumbers(input)), getBonusNumber());
    }

    @Override
    public LottoNumber getBonusNumber() {
        return LottoNumber.of(4);
    }

    public Integer parseInt() {
        return Integer.parseInt(this.input);
    }
}
