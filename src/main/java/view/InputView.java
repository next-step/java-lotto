package view;

import domain.Lotto;
import domain.LottoMoney;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static LottoMoney getLottoCountFromInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        LottoMoney money = new LottoMoney(scanner.nextInt());

        System.out.println(money.getNumberOfLotto() + "개를 구매했습니다");
        return money;
    }


    public static WinningLotto getWinnerNoByInput() {

        System.out.println("지난 주 당첨 번호를 입력해 주세요.(,로 숫자 구분)");
        Scanner scanner = new Scanner(System.in);
        String[] inputs = splitStringToWinner(scanner.nextLine());

        List<Integer> speicifedNumbers = new ArrayList<>();
        for(String input : inputs) {
            speicifedNumbers.add(toInt(input));
        }

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        return new WinningLotto(speicifedNumbers, bonusNumber);
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }

    private static String[] splitStringToWinner(String input) {
        return input.split(",");
    }


}
