package lotto.view.fake;


import lotto.domain.PaymentReceipt;
import lotto.domain.Quantity;
import lotto.domain.product.lotto.LotteryTicket;
import lotto.domain.product.lotto.LotteryTickets;
import lotto.domain.product.lotto.LottoNumber;
import lotto.domain.product.lotto.WinningTicket;
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

    @Override
    public Quantity getManualLotteryQuantity() {
        return new Quantity(this.input);
    }

    @Override
    public LotteryTickets getManualLotteryTickets(Quantity manual) {
        LotteryTickets lotteryTickets = new LotteryTickets();
        for (int i = 0; i < manual.value(); i++) {
            lotteryTickets.add(getTicket(this.input));
        }
        return lotteryTickets;
    }

    public Integer parseInt() {
        return Integer.parseInt(this.input);
    }
}
