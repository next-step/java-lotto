package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.LottoMachine;
import lotto.view.UserView;

public class LottoManager {
    private static boolean validMoney;
    private static boolean validLottoNumbers;
    public static void main(String[] args) {
        LottoMachine machine = new LottoMachine();
        UserView view = new UserView();
        LottoGame winGame;
        int money = -1;

        view.println("구입금을 입력해 주세요.");
        do {
            money = parseMoney(view);
        } while(!validMoney);
        int lottoGameCount = money / LottoGame.PRICE;
        view.println(String.format("%d개를 구매했습니다.",lottoGameCount));

        LottoGames lottoGames = machine.createLottoGames(money);

        for (LottoGame game : lottoGames) {
            view.println(game);
        }

        view.enter();
        view.println("지난 주 당첨 번호를 입력해 주세요.");
        do {
            winGame = parseLottoNumbers(view);
        } while(!validLottoNumbers);
        view.enter();

        view.println(machine.calculateStatics(winGame));
    }

    private static LottoGame parseLottoNumbers(UserView view) {
        try {
            LottoGame winGame = new LottoGame(view.nextIntArray());
            validLottoNumbers = true;
            return winGame;
        } catch (Exception e) {
            view.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
        return new LottoGame();
    }

    private static int parseMoney(UserView view) {
        try {
            int money = Integer.parseInt(view.nextLine());
            setValidMoney(money);
            return money;
        } catch (Exception e) {
            view.println("잘못된 입력입니다. 다시 입력해주세요");
        }

        return 0;
    }

    private static void setValidMoney(int money) {
        if( money > 0) {
            validMoney = true;
        }
    }
}
