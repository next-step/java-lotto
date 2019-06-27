package lotto.view.input;

import java.util.List;

public class DefaultInputView implements InputView {

    private static final String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    private final CommandLineReader commandLineReader;

    public DefaultInputView(CommandLineReader commandLineReader) {
        this.commandLineReader = commandLineReader;
    }

    @Override
    public Long getPurchaseAmount() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        return commandLineReader.readNumber();
    }

    @Override
    public List<Long> getWinningTicket() {
        System.out.println(MESSAGE_WINNING_NUMBERS);
        return commandLineReader.readCsvLongValues();
    }
}