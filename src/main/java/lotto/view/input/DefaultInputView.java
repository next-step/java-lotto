package lotto.view.input;

import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;

public class DefaultInputView implements InputView {

    private static final String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    private final CommandLineReader commandLineReader;

    public DefaultInputView(CommandLineReader commandLineReader) {
        this.commandLineReader = commandLineReader;
    }

    @Override
    public PurchaseAmount getPurchaseAmount() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        return PurchaseAmount.of(commandLineReader.readNumber());
    }

    @Override
    public LottoTicket getWinningTicket() {
        System.out.println(MESSAGE_WINNING_NUMBERS);
        return LottoTicket.of(commandLineReader.readCsvLongValues());
    }
}