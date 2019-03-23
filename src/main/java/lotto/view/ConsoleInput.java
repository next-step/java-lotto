package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

    public static long inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextInt();
    }

    public static WinningLotto inputLastWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();

        String[] numbers = input.split(", ");
        List<LottoNumber> winningNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            winningNumbers.add(new LottoNumber(Integer.parseInt(numbers[i])));
        }

        System.out.println("보너스 볼을 입력해 주세요.");
        LottoNumber bonusNumber = new LottoNumber(scanner.nextInt());

        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }
}
