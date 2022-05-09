package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int getPurchasedAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int value = scanner.nextInt();
        scanner.nextLine();

        return value;
    }

    public void printAmount(int numOfTickets) {
        System.out.println(numOfTickets + "개를 구매했습니다.");
    }

    public String printPurchasedLottoTickets() {
        System.out.println("지난주 당첨 번호를 알려주세요.");
        String input = scanner.nextLine();

        return input;
    }
}