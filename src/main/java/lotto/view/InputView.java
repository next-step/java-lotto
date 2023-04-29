package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static final int PRICE_OF_LOTTO_TICKET = 1000;

    private InputView() {
    }

    public static int calculateNumberOfTicketsToBuy() {
        System.out.println("구입금액을 입력해 주세요.");
        int amountOfMoney = SCANNER.nextInt();
        SCANNER.nextLine();
        int numberOfTickets = Math.floorDiv(amountOfMoney, PRICE_OF_LOTTO_TICKET);
        System.out.println(numberOfTickets + "개를 구매했습니다.");
        return numberOfTickets;
    }


    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }
}
