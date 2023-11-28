package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {

    @Override
    public int purchase() {
        System.out.println("구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        int payment = scanner.nextInt();
        int amount = payment / Lotto.PRICE;
        System.out.println(amount + "개를 구입했습니다.");
        return amount;
    }

    public WinningLotto winningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        String winningLottoString = scanner.nextLine();
        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = scanner.nextInt();
        System.out.println();
        return new WinningLotto(new Lotto(stringToList(winningLottoString)), bonusNumber);
    }

    private List<Integer> stringToList(String winningLottoString) {
        return Arrays
                .stream(winningLottoString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
