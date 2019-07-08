package lotto.view.input;

import lotto.common.Csv;
import lotto.common.PositiveNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DefaultInputView implements InputView {

    private static final String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_MANUAL_TICKET_PUCHASE_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_MANUAL_TICKET_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private final CommandLineReader commandLineReader;

    public DefaultInputView(CommandLineReader commandLineReader) {
        this.commandLineReader = commandLineReader;
    }

    @Override
    public PositiveNumber getPurchaseAmount() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        return commandLineReader.readNumber();
    }

    @Override
    public List<Csv> getManualTicketNumbers() {
        return getManualTicketNumbers(getManualTicketPurchaseCount());
    }

    private PositiveNumber getManualTicketPurchaseCount() {
        System.out.println(MESSAGE_MANUAL_TICKET_PUCHASE_COUNT);
        return commandLineReader.readNumber();
    }

    private List<Csv> getManualTicketNumbers(PositiveNumber manualTicketPurchaseCount) {
        System.out.println(MESSAGE_MANUAL_TICKET_NUMBERS);
        return LongStream.range(0, manualTicketPurchaseCount.get())
                .mapToObj(notUsed -> commandLineReader.readCsv())
                .collect(Collectors.toList());
    }

    @Override
    public Csv getWinningTicket() {
        System.out.println(MESSAGE_WINNING_NUMBERS);
        return commandLineReader.readCsv();
    }

    @Override
    public PositiveNumber getBonusNumber() {
        System.out.println(MESSAGE_BONUS_NUMBER);
        return commandLineReader.readNumber();
    }
}