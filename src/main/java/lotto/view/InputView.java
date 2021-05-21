package lotto.view;

import lotto.domain.AmountMoney;
import utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_QUESTION_HOW_MANY_BUY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_QUESTION_WINNER_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public AmountMoney amountMoneyOfBuyTicket() {
        System.out.println(MESSAGE_QUESTION_HOW_MANY_BUY);
        int inputAmountMoney = Integer.parseInt(scanner.nextLine());

        return AmountMoney.create(inputAmountMoney);
    }

    public List<String> inputWinnerNumber() {
        System.out.println(MESSAGE_QUESTION_WINNER_NUMBER);
        String inputWinnerNumber = scanner.nextLine();
        String[] winnerNumbers = StringUtils.split(inputWinnerNumber);
        return Arrays.asList(winnerNumbers);
    }
}
