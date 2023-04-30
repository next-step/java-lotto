package lotto.biz;

import lotto.model.Lotto;
import lotto.model.LottoGames;
import lotto.view.InputView;

public class LottoService {

    private static String SHOW_GAME_COUNT_FORMAT = "%s개를 구매했습니다.";

    private LottoGames games;

    public LottoService() {
    }

    public void setPurchaseValue() {
        int lottoCount = InputView.setSaleAmount()/ Lotto.LOTTO_PRICE;
        System.out.println(String.format(
                SHOW_GAME_COUNT_FORMAT, lottoCount)
        );
        games= new LottoGames(lottoCount);
        games.showAllTickets();
    }

    public void setWinningNumbers() {
        String winningNumbers = InputView.setWinningNumbers();

        if(games == null){
            throw new RuntimeException("구입 금액을 먼저 입력해주세요.");
        }

        games.setWinningNumbers(winningNumbers);
    }

    public void getWinningStatistics() {

    }
}
