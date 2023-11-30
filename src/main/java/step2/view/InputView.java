package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoGame;
import step2.domain.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static step2.domain.LottoGame.ONE_TRY_MONEY;
import static step2.generator.Lotto45NumbersMakeStrategy.PICK_NUMBERS;

public class InputView implements View{

    private final String REQUEST_INPUT = "구입금액을 입력해 주세요.";

    private final String HOW_MANY_BUY = "%d개를 구매했습니다.";

    private final String REQUEST_LAST_WEEK_WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";


    Scanner scanner = new Scanner(System.in);

    public Money start() {
        System.out.println(REQUEST_INPUT);
        int tryMoneyNumber = scanner.nextInt();
        Money tryMoney = new Money(tryMoneyNumber);
        showHowManyBuy(tryMoney);
        return tryMoney;
    }

    private void showHowManyBuy(Money tryMoney) {
        int tryNumber = tryMoney.divide(ONE_TRY_MONEY).intValue();
        System.out.printf(HOW_MANY_BUY, tryNumber);
    }

    public void showInputLotto(LottoGame lottoGame) {
        lottoGame.getLotto().forEach(System.out::println);
    }

    public Lotto winLotto() {
        System.out.println(REQUEST_LAST_WEEK_WIN_NUMBER);
        Lotto lotto = Lotto.create(getWinLottoNumbers());
        System.out.println(lotto.getNumbers());
        return lotto;
    }

    private List<Integer> getWinLottoNumbers() {
        List<Integer> winLottoNumbers = new ArrayList<>();
        for (int i = 0; i < PICK_NUMBERS; i++) {
            winLottoNumbers.add(scanner.nextInt());
        }
        return winLottoNumbers;
    }
}
