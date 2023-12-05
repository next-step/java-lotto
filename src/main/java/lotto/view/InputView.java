package lotto.view;

import com.sun.source.doctree.BlockTagTree;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;
import static lotto.domain.LottoGame.ONE_TRY_MONEY;
import static lotto.generator.Lotto45NumbersMakeStrategy.PICK_NUMBERS;

public class InputView implements View {

    private final String LOTTO_NUMBER_PRINT_FORMAT = "[%s]";

    private final String REQUEST_INPUT = "구입금액을 입력해 주세요.";

    private final String HOW_MANY_BUY = "%d개를 구매했습니다.";

    private final String REQUEST_LAST_WEEK_WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    Scanner scanner = new Scanner(System.in);

    public Money gameStart() {
        System.out.println(REQUEST_INPUT);
        int tryMoneyNumber = scanner.nextInt();
        return new Money(tryMoneyNumber);
    }

    private void showHowManyBuy(int howManyTry) {
        print(HOW_MANY_BUY, howManyTry);
    }

    public void showInputLotto(LottoGame lottoGame) {
        showHowManyBuyLotto(lottoGame);
        lottoGame.createFormattedLotto().forEach(formattedLotto -> {
            print(LOTTO_NUMBER_PRINT_FORMAT, formattedLotto);
            nextLine();
        });
    }

    private void showHowManyBuyLotto(LottoGame lottoGame) {
        print(HOW_MANY_BUY, lottoGame.howManyCanTry());
        nextLine();
    }

    public Lotto winLotto() {
        print(REQUEST_LAST_WEEK_WIN_NUMBER);
        Lotto lotto = Lotto.create(makeWinLottoNumbers());
        print(lotto.createFormattedLotto());
        nextLine();
        return lotto;
    }

    private List<Integer> makeWinLottoNumbers() {
        List<Integer> winLottoNumbers = new ArrayList<>();
        for (int i = 0; i < PICK_NUMBERS; i++) {
            winLottoNumbers.add(scanner.nextInt());
        }
        return winLottoNumbers;
    }
}
