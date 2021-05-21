package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.LottoMachine;
import lotto.view.UserView;

public class LottoManager {
    private static boolean validLottoNumbers;
    private static int money;
    private static LottoMachine machine = new LottoMachine();
    private static UserView view = new UserView();
    private static LottoGame winGame;

    public static void main(String[] args) {
        view.println("구입금을 입력해 주세요.");
        parseMoneyUntilOverZero();
        int lottoGameCount = getLottoGameCount();
        view.println(String.format("%d개를 구매했습니다.",lottoGameCount));

        createAndPrintLottoGame();

        view.enter();
        view.println("지난 주 당첨 번호를 입력해 주세요.");
        parseLottoNumbersUntilValid();
        view.enter();

        view.println(machine.calculateStatics(winGame));
    }

    private static void parseLottoNumbersUntilValid() {
        do {
            winGame = parseLottoNumbers(view);
        } while(winGame == null);
    }

    private static void parseMoneyUntilOverZero() {
        do {
            money = parseMoney(view);
        } while(money <= 0);
    }

    private static void createAndPrintLottoGame() {
        LottoGames lottoGames = machine.createLottoGames(money);
        for (LottoGame game : lottoGames) {
            view.println(game);
        }
    }

    private static int getLottoGameCount() {
        return money / LottoGame.PRICE;
    }

    private static LottoGame parseLottoNumbers(UserView view) {
        try {
            return new LottoGame(view.nextIntArray());
        } catch (Exception e) {
            view.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
        return null;
    }

    private static int parseMoney(UserView view) {
        try {
            return Integer.parseInt(view.nextLine());
        } catch (Exception e) {
            view.println("잘못된 입력입니다. 다시 입력해주세요");
        }
        return 0;
    }

}
