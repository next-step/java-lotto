package lotto.view;

import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Winners;

import java.util.Scanner;

public class WinningNumberView {
    private WinningNumberView(){}

    public static Winners getWinner(Lottos lottos) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine();

        System.out.println("보너스 볼을 입력 해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());

        Winners winners = LottoStore.getWinner(lottos, winningNumbers.split(","), bonusNumber);

        return winners;
    }
}
