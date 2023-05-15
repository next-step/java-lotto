package lotto.biz;

import lotto.model.Lotto;
import lotto.model.LottoGames;
import lotto.model.enums.MatchingStrategy;
import lotto.util.ParseUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class LottoService {
    public static final String COMMA = ",";
    private LottoGames games;

    public LottoService() {
        games = new LottoGames();
    }

    public void setPurchaseValue(int purchaseValue) {
        games.setPurchaseValue(purchaseValue);
    }

    public void setWinningNumbers(String winningNumbers) {
        if (games == null) {
            throw new RuntimeException("구입 금액을 먼저 입력해주세요.");
        }

        games.setWinningNumbers(ParseUtil.convertStringToIntegerList(winningNumbers, COMMA));
    }

    public void aggregateWinningStatistics() {
        games.aggregate();
    }


    public Map<MatchingStrategy, List<Lotto>> getStatistic() {
        return games.getStatistic();
    }

    public int getPurchaseValue() {
        return games.getPurchaseValue();
    }

    public Set<Integer> getWinningNumbers() {
        return games.getWinningNumbers();
    }

    public List<Lotto> getGames() {
        return games.getGames();
    }

    public void setBonusNumber(String input) {
        games.setBonusNumber(Integer.parseInt(input));
    }

    public Integer getBonusNumber() {
        return games.getBonusNumber();
    }

    public void setManualLottoCount(int input) {
        games.setManualLottoCount(input);
    }

    public int getManualLottoCount() {
        return games.getManualLottoCount();
    }

    public void addManualLottoNumbers(Set<Integer> input) {
        games.addLotto(new Lotto(input));
    }

    public void addAutoLottoNumbers() {
        games.initGames(games.getAutoLottoCount());
    }

    public int getAutoLottoCount() {
        return games.getAutoLottoCount();
    }
}
