package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoManager {
    private static int money;
    private static LottoMachine machine = new LottoMachine();
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();
    private static LottoGame winGame;

    public static void main(String[] args) {
        resultView.println("구입금을 입력해 주세요.");
        parseMoneyUntilOverZero();
        int lottoGameCount = getLottoGameCount();
        resultView.println(String.format("%d개를 구매했습니다.",lottoGameCount));

        createAndPrintLottoGame();

        resultView.enter();
        resultView.println("지난 주 당첨 번호를 입력해 주세요.");
        parseLottoNumbersUntilValid();
        resultView.enter();

        resultView.println(machine.calculateStatics(winGame));
    }

    private static void parseLottoNumbersUntilValid() {
        do {
            winGame = parseLottoNumbers();
        } while(winGame == null);
    }

    private static void parseMoneyUntilOverZero() {
        do {
            money = parseMoney();
        } while(money <= 0);
    }

    private static void createAndPrintLottoGame() {
        LottoGames lottoGames = machine.createLottoGames(money);
        for (LottoGame game : lottoGames) {
            resultView.println(game);
        }
    }

    private static int getLottoGameCount() {
        return money / LottoGame.PRICE;
    }

    private static LottoGame parseLottoNumbers() {
        try {
            return new LottoGame(inputView.nextIntArray());
        } catch (Exception e) {
            resultView.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
        return null;
    }

    private static int parseMoney() {
        try {
            return Integer.parseInt(inputView.nextLine());
        } catch (Exception e) {
            resultView.println("잘못된 입력입니다. 다시 입력해주세요");
        }
        return 0;
    }

}
