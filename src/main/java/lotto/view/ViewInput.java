package lotto.view;

import java.util.Scanner;

public class ViewInput {
    public final static String INPUT_EXPENSE_MESSAGE = "구입금액을 입력해 주세요.";
    public final static String INPUT_NUM_TICKET_MESSAGE = "%s개를 구매했습니다.";
    public final static Integer PRICE_LOTTO_TICKET = 1000;

    public static int getExpense(){
        System.out.println(INPUT_EXPENSE_MESSAGE);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static int getAvailableNumLottoTicket(int expense){
        int numLottoTicket = (expense / PRICE_LOTTO_TICKET);
        System.out.println(String.format(INPUT_NUM_TICKET_MESSAGE, numLottoTicket));
        return numLottoTicket;
    }
}
