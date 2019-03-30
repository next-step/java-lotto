package view;

import domain.LottoNo;
import util.Console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SEPARATOR = ",";

    public static int inputMoney() throws InputMismatchException {
        Console.print("구입금액을 입력하세요.");
        return new Scanner(System.in).nextInt();
    }

    public static void inputWinningNumbers() {
        Console.print("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static int inputBonusBall() throws InputMismatchException {
        Console.print("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static int buyManualLotto() throws InputMismatchException {
        Console.print("수동으로 구매할 로또 수를 입력하세요.");
        return new Scanner(System.in).nextInt();
    }

    public static void inputManualLottoNumbers() {
        Console.print("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static List<LottoNo> scanLottoNumbers() throws NumberFormatException {
        List<LottoNo> lottoNumbers = new ArrayList<>();
        String [] numbers = new Scanner(System.in).nextLine().split(SEPARATOR);
        for (String number : numbers) {
            lottoNumbers.add(new LottoNo(Integer.parseInt(number.trim())));
        }
        return lottoNumbers;
    }

}