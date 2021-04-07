package step2.view;

import java.util.Scanner;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static int payment;
    private static int numberOfLottoTickets;

    public static void inputPayments(){
        Scanner scan = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        payment = scan.nextInt();
        numberOfLottoTickets = payment /LOTTO_PRICE;
    }

    public static int getNumberOfLottoTickets(){
        return numberOfLottoTickets;
    }
}
