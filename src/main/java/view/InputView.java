package view;

import domain.Attempt;
import domain.LottoAmount;
import domain.LottoNo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static domain.LottoWinningNo.isContainSameNumber;
import static util.CollectionCast.changeListToMap;
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

    public static List<List<LottoNo>> printManualPurchaseNumber(LottoAmount amount) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");

        List<List<LottoNo>> manualPurchaseNumbers = new ArrayList();
        for (int i = 0; i < amount.getAmount(); i++) {
            Scanner scanner = new Scanner(System.in);
            manualPurchaseNumbers.add(changeWinNumberToInteger(scanner.next()));
        }
        return manualPurchaseNumbers;
    }

    public static void printLottoAmount(LottoAmount manualPurchaseAmount, LottoAmount autoPurchaseAmount) {
        System.out.println(String.format("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualPurchaseAmount.getAmount(), autoPurchaseAmount.getAmount()));
    }

    public static void printLottoNumber(List<Attempt> lottoNumbers) {
        for (Attempt lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getLottoNos().values().stream()
                    .map(LottoNo::getNumber)
                    .collect(Collectors.toList()));
        }
    }

    public static List<LottoNo> printLastWeekWinNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winNumber = scanner.next();

        return changeWinNumberToInteger(winNumber);
    }

    public static int printBonusNumber(List<LottoNo> winnerNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int bonusNumber = scanner.nextInt();

        if(isContainSameNumber(changeListToMap(winnerNumbers), new LottoNo(bonusNumber)))
            throw new RuntimeException("보너스 볼은 담청 번호와 같을 수 없습니다.");

        return bonusNumber;
    }

}
