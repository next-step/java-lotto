package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinnerLotto;
import util.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int createBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int createBuyManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Lotto> createBuyManualLottos(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Parser.convertToInteger(scanner.next());
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }


    public static WinnerLotto createWinnerLotto() {
        return new WinnerLotto(createWinnerNumbers(), createBonusNumber());
    }
    private static Lotto createWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> numbers = Parser.convertToInteger(scanner.next());
        return new Lotto(numbers);
    }

    private static int createBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
