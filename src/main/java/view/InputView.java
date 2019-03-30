package view;

import util.Console;
import util.Generator;

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
        int bonusBall = new Scanner(System.in).nextInt();
        if (bonusBall < Generator.MIN_LOTTO_NUMBER || bonusBall > Generator.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 범위를 벗어났습니다.");
        }
        return bonusBall;
    }

    public static int buyManualLotto() throws InputMismatchException {
        Console.print("수동으로 구매할 로또 수를 입력하세요.");
        return new Scanner(System.in).nextInt();
    }

    public static void inputManualLottoNumbers() {
        Console.print("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static List<Integer> scanLottoNumbers() throws NumberFormatException {
        List<Integer> lottoNumbers = new ArrayList<>();
        String [] numbers = new Scanner(System.in).nextLine().split(SEPARATOR);
        for (String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number.trim()));
        }
        return lottoNumbers;
    }

}