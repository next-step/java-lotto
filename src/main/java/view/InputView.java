package view;

import domain.Attempt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static util.ConsoleUtil.changeWinNumberToInteger;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();

        return money;
    }

    public static int getManualPurchaseAmount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();

        return amount;
    }

    public static List<List<Integer>> printManualPurchaseNumber(int amount) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");

        List<List<Integer>> manualPurchaseNumbers = new ArrayList();
        for (int i = 0; i < amount; i++) {
            Scanner scanner = new Scanner(System.in);
            manualPurchaseNumbers.add(changeWinNumberToInteger(scanner.next()));
        }
        return manualPurchaseNumbers;
    }

    public static void printLottoAmount(int manualPurchaseAmount, int autoPurchaseAmount) {
        System.out.println(String.format("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualPurchaseAmount, autoPurchaseAmount));
    }

    public static void printLottoNumber(List<Attempt> lottoNumbers) {
        for (Attempt lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getNumbers());
        }
    }

    public static List<Integer> printLastWeekWinNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winNumber = scanner.next();

        return changeWinNumberToInteger(winNumber);
    }

    public static int printBonusNumber(List<Integer> winnerNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int bonusNumber = scanner.nextInt();

        if(winnerNumbers.contains(bonusNumber))
            throw new RuntimeException("보너스 볼은 담청 번호와 같을 수 없습니다.");

        return bonusNumber;
    }
}
