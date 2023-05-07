package lotto.biz;

import lotto.model.Lotto;
import lotto.model.LottoGames;
import lotto.model.enums.Ranking;
import lotto.util.ParseUtil;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LottoService {
    public static final String COMMA = ", ";
    private static String SHOW_GAME_COUNT_FORMAT = "%s개를 구매했습니다.";

    private LottoGames games;

    public LottoService() {
    }

    public void setPurchaseValue(int purchaseValue) {
        int lottoCount = purchaseValue / Lotto.LOTTO_PRICE;
        System.out.println(String.format(
                SHOW_GAME_COUNT_FORMAT, lottoCount)
        );
        games= new LottoGames(lottoCount);
    }

    public void setWinningNumbers(String winningNumbers) {
        if(games == null){
            throw new RuntimeException("구입 금액을 먼저 입력해주세요.");
        }

        games.setWinningNumbers(ParseUtil.convertStringToIntegerList(winningNumbers, COMMA));
    }

    public void aggregateWinningStatistics() {
        games.aggregate();
    }


    public Map<Ranking, List<Lotto>> getStatistic(){
        return games.getStatistic();
    }

    public int getPurchaseValue() {
        return games.getGameCount() * Lotto.LOTTO_PRICE;
    }

    public List<Integer> getWinningNumbers(){
        return games.getWinningNumbers();
    }

    public List<Lotto> getGames(){
        return games.getGames();
    }
}
