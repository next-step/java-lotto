package view;

import domain.Attempt;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();

        return money;
    }

    public static void printLottoAmount(int amount) {
        System.out.println( amount + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Attempt> lottoNumbers) {
        for (Attempt lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getNumbers());
        }
    }

    public static String printLastWeekWinNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winNumber = scanner.next();

        return winNumber;
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
