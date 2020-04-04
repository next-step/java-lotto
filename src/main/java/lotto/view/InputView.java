package lotto.view;

import lotto.model.LottoTicket;
import lotto.model.LottoTickets;
import lotto.model.wrapper.LottoNumber;
import lotto.model.wrapper.ManualLottoCount;
import lotto.model.wrapper.Payment;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static lotto.utils.LottoUtil.convertTo;

public class InputView {

    private InputView() {
    }

    public static <R> R inputData(Supplier<R> inputSupplier) {
        R result = null;
        while (result == null) {
            result = inputSupplier.get();
        }
        return result;
    }

    public static <T, R> R inputData(T semiInputComponent, Function<T, R> inputFunction) {
        R result = null;
        while (result == null) {
            result = inputFunction.apply(semiInputComponent);
        }
        return result;
    }

    public static Payment inputPayment() {
        try {
            return Payment.of(InputConsoleView.inputPayment());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static ManualLottoCount inputManualLottoCount() {
        try {
            return ManualLottoCount.of(InputConsoleView.inputManualLottoCount());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static LottoTickets inputManualLotto(ManualLottoCount manualLottoCount) {
        try {
            List<String> lottoNumberLines = InputConsoleView.inputManualLotto(manualLottoCount.getCount());
            return LottoTickets.newInstance(convertTo(lottoNumberLines));
        } catch (NumberFormatException ex) {
            System.out.println("제대로 된 숫자를 입력하세요");
            return null;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static LottoTicket inputWinningNumber() {
        try {
            String line = InputConsoleView.inputWinningNumber();
            return LottoTicket.newInstance(convertTo(line));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static LottoNumber inputBonusNumber() {
        try {
            return LottoNumber.of(InputConsoleView.inputBonusNumber());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
