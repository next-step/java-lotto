package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static step2.generator.Lotto45NumbersMakeStrategy.PICK_NUMBERS;

public class InputView {

    private final String REQUEST_INPUT = "구입금액을 입력해 주세요.";

    private final String HOW_MANY_BUY = "%d개를 구매했습니다.";

    private final String REQUEST_LAST_WEEK_WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private final int ONE_TRY_MONEY = 1_000;

    Scanner scanner = new Scanner(System.in);

    public int start() {
        System.out.println(REQUEST_INPUT);
        int tryMoney = scanner.nextInt();
        int tryNumber = tryMoney / ONE_TRY_MONEY;
        System.out.printf(HOW_MANY_BUY, tryNumber);
        return tryNumber;
    }

    public void nextLine() {
        System.out.println();
    }

    public void showInputLotto(LottoGame lottoGame) {
        lottoGame.getLotto().forEach(System.out::println);
    }

    public Lotto winLotto() {
        System.out.println(REQUEST_LAST_WEEK_WIN_NUMBER);
        List<Integer> winLottoNumbers = new ArrayList<>();
        for (int i = 0; i < PICK_NUMBERS; i++) {
            winLottoNumbers.add(scanner.nextInt());
        }
        Lotto lotto = Lotto.create(winLottoNumbers);
        System.out.println(lotto.getNumbers());
        return lotto;
    }
}
