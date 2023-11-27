package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public Lotto winningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        String winningLottoString = scanner.nextLine();
        System.out.println();
        return makeWinningLotto(winningLottoString);
    }

    private Lotto makeWinningLotto(String winningLottoString) {
        return new Lotto(stringToList(winningLottoString));
    }

    private List<Integer> stringToList(String winningLottoString) {
        List<Integer> lotto = new ArrayList<>();
        for (String pastLottoNo : winningLottoString.split(",")) {
            lotto.add(Integer.parseInt(pastLottoNo.trim()));
        }
        return lotto;
    }
}
