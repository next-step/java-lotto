package lotto.views;

import java.util.List;
import java.util.Scanner;
import lotto.domains.Lotto;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public void printPurchasedLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        lottoList.forEach(System.out::println);
    }

    public String inputLastWinner() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input =  scanner.nextLine();
        System.out.println();
        return input;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }
}
