package lotto.view;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner scannerForString = new Scanner(System.in);

    public static int getAmountOfPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int getBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int getNumOfManualTicket() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String []> getManualLottoTickets(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String[]> manualTickets = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String inputValue = scannerForString.nextLine();
            String[] splittedInputValue = inputValue.split(", ");
            manualTickets.add(splittedInputValue);
        }
        return manualTickets;
    }
}
