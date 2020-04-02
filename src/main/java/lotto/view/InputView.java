package lotto.view;

import lotto.model.LottoTicket;
import lotto.model.LottoTickets;
import lotto.model.wrapper.LottoNumber;
import lotto.model.wrapper.ManualLottoCount;
import lotto.model.wrapper.Payment;

import java.util.List;

import static lotto.utils.LottoUtil.convertTo;

public class InputView {

    private InputView() {
    }

    public static Payment inputPayment() {
        try {
            return Payment.of(InputConsoleView.inputPayment());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputPayment();
        }
    }

    public static ManualLottoCount inputManualLottoCount() {
        try {
            return ManualLottoCount.of(InputConsoleView.inputManualLottoCount());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputManualLottoCount();
        }
    }

    public static LottoTickets inputManualLotto(ManualLottoCount manualLottoCount) {
        try {
            List<String> lottoNumberLines = InputConsoleView.inputManualLotto(manualLottoCount.getCount());
            return LottoTickets.newInstance(convertTo(lottoNumberLines));
        } catch (NumberFormatException ex) {
            System.out.println("제대로 된 숫자를 입력하세요");
            return inputManualLotto(manualLottoCount);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputManualLotto(manualLottoCount);
        }
    }

    public static LottoTicket inputWinningNumber() {
        try {
            String line = InputConsoleView.inputWinningNumber();
            return LottoTicket.newInstance(convertTo(line));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputWinningNumber();
        }
    }

    public static LottoNumber inputBonusNumber() {
        try {
            return LottoNumber.of(InputConsoleView.inputBonusNumber());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return inputBonusNumber();
        }
    }

}
