package lotto.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.message.Message;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.strategy.GenerateLottoNumber;

public class LotteryDraw {

  private LottoMoney lottoMoney;

  private Lotties lotties;

  private static final String SPLIT_MARK = ",";

  private static final int EACH_LOTTO_COST = 1000;

  private static final String PROFIT_RATE_FORMAT = "#.##";

  private static final int INT_ZERO = 0;

  private static final int LIMIT_MATCH_NUMBER = 3;

  public LotteryDraw(int money) {
    this.lottoMoney = new LottoMoney(money);
  }

  public LotteryDraw() {

  }

  private void checkInputValue() {
    if (Operation.chooseOperation("%").calculation(lottoMoney.getMoney(), EACH_LOTTO_COST) != INT_ZERO) {
      throw new RuntimeException(Message.MSG_ERROR_WRONG_MONEY);
    }
  }

  private int getNumberOfLotto() {
    return Operation.chooseOperation("/").calculation(lottoMoney.getMoney(), EACH_LOTTO_COST);
  }

  public void buyLotties(GenerateLottoNumber generateLottoNumber) {
    checkInputValue();
    lotties = new Lotties(getNumberOfLotto(), generateLottoNumber);
  }

  public Lotties getLottiesInfo() {
    return lotties;
  }

  public Lotto inputWinningNumbers(String winningLottery) {
    return Lotties.getWinningLotto(winningLottery.trim().split(SPLIT_MARK));
  }

  public Map<Integer, List<Lotto>> matchLottoInfo(Lotties lotties, Lotto winLotto) {

    Map<Integer, List<Lotto>> categoriesRank = createRatingInfo();
    lotties.getLotties().forEach(
        lotty -> categoriesRank.get(matchLottoRating(lotties, winLotto, lotty)).add(lotty));

    categoriesRank.remove(INT_ZERO);

    return categoriesRank;
  }

  private int matchLottoRating(Lotties lotties, Lotto winLotto, Lotto lotty) {
    int matchLotties = lotties.getMatchLotties(lotty, winLotto);
    if (matchLotties < LIMIT_MATCH_NUMBER) {
      return INT_ZERO;
    }
    return matchLotties;
  }

  private Map<Integer, List<Lotto>> createRatingInfo() {
    Map<Integer, List<Lotto>> categoriesRank = new LinkedHashMap<>();

    categoriesRank.put(Rank.FIFTH.getCountOfMatch(), new ArrayList<>());
    categoriesRank.put(Rank.FOURTH.getCountOfMatch(), new ArrayList<>());
    categoriesRank.put(Rank.THIRD.getCountOfMatch(), new ArrayList<>());
    categoriesRank.put(Rank.SECOND.getCountOfMatch(), new ArrayList<>());
    categoriesRank.put(Rank.FIRST.getCountOfMatch(), new ArrayList<>());
    categoriesRank.put(Rank.MISS.getCountOfMatch(), new ArrayList<>());

    return categoriesRank;
  }

  public String gradingScore(Map<Integer, List<Lotto>> result) {

    int totalWinningRewards = INT_ZERO;

    for (Integer ratingNumber : result.keySet()) {
      totalWinningRewards += Operation.chooseOperation("*")
          .calculation(result.get(ratingNumber).size(),
              Rank.matchRank(ratingNumber).getWinningMoney());
    }

    return formattingValue(totalWinningRewards);
  }

  private String formattingValue(int totalWinningRewards) {

    DecimalFormat format = new DecimalFormat(PROFIT_RATE_FORMAT);
    format.setRoundingMode(RoundingMode.DOWN);

    return format.format((double) totalWinningRewards / (double) lottoMoney.getMoney());
  }

}