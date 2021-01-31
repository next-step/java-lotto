package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String TOTAL_COST_MSG = "구입금액을 입력해 주세요.";
    private static final String MANUAL_TICKET_CNT_MSG = "수동으로 구매한 로또 수를 입력해 주세요.";
    private static final String MANUAL_TICKETS_INPUT_MSG = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String ANSWER_NUMBERS_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MSG = "보너스 볼을 입력해 주세요";

    private static Scanner scanner = new Scanner(System.in);

    public Integer inputTotalCost() {
        System.out.println(TOTAL_COST_MSG);
        Integer totalCost = scanner.nextInt();
        scanner.nextLine(); // To remove new line character.
        return totalCost;
    }

    public Integer inputManualTicketCnt() {
        System.out.println(MANUAL_TICKET_CNT_MSG);
        Integer manualTicketCnt = scanner.nextInt();
        scanner.nextLine();
        return manualTicketCnt;
    }

    public void inputManualTicketsNumbers() {
        System.out.println(MANUAL_TICKETS_INPUT_MSG);
    }

    public String inputAnswerNumbers() {
        System.out.println(ANSWER_NUMBERS_MSG);
        return inputTicketsNumbers();
    }

    public String inputTicketsNumbers() {
        return scanner.nextLine();
    }

    public Integer inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MSG);
        return scanner.nextInt();
    }
}
