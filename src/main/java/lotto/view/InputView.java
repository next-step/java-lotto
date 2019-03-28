package lotto.view;

import lotto.domain.LottoNumber;

import java.util.Scanner;

public class InputView {

    public static int getAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요");
        return scanner.nextInt();
    }

    public static String[] getManualTicketNumber(int manualTicketCount) {
        Scanner scanner = new Scanner(System.in);
        String[] tickects =new String[manualTicketCount];
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualTicketCount; i++) {
            tickects[i]= scanner.nextLine();
        }
        return tickects;

    }

    public static int getManualTicketCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }


    public static String getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static LottoNumber getBonusNumber() {
        System.out.println("보너스 숫자 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        return LottoNumber.getBasicNumber(inputNumber);
    }
}
