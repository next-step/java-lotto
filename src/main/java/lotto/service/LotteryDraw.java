package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.message.Message;
import lotto.strategy.GenerateLottoNumber;

public class LotteryDraw {

  private LottoMoney lottoMoney;

  private Lotteries lotteries;

  private static final String SPLIT_MARK = ",";

  private static final int EACH_LOTTO_COST = 1000;

  private static final int INT_ZERO = 0;

  private static final int LIMIT_MATCH_NUMBER = 3;

  public LotteryDraw(int money) {
    this.lottoMoney = new LottoMoney(money);
  }

  public LotteryDraw() {

  }

  private void checkInputValue() {
    if (lottoMoney.calculateMoney("%", EACH_LOTTO_COST) != INT_ZERO) {
      throw new RuntimeException(Message.MSG_ERROR_WRONG_MONEY);
    }
  }

  private int getNumberOfLotto() {
    return lottoMoney.calculateMoney("/", EACH_LOTTO_COST);
  }

  public void buyLotteries(GenerateLottoNumber generateLottoNumber) {
    checkInputValue();
    lotteries = new Lotteries(getNumberOfLotto(), generateLottoNumber);
  }

  public Lotteries getLotteriesInfo() {
    return lotteries;
  }

  public Lotto inputWinningNumbers(String winningLottery) {
    return Lotteries.getWinningLotto(new ArrayList<>(Arrays.asList(winningLottery.trim().split(SPLIT_MARK))));
  }

  public Map<Integer, List<Lotto>> matchLottoInfo(Lotteries lotteries, Lotto winLotto) {

    Map<Integer, List<Lotto>> categoriesRank = createRatingInfo();
    lotteries.getLotteries().forEach(
        lotty -> categoriesRank.get(matchLottoRating(winLotto, lotty)).add(lotty));

    categoriesRank.remove(INT_ZERO);

    return categoriesRank;
  }

  private int matchLottoRating(Lotto winLotto, Lotto lotty) {
    int matchLotteries = lotteries.getMatchLotteries(lotty, winLotto);

    if (matchLotteries < LIMIT_MATCH_NUMBER) {
      return INT_ZERO;
    }
    return matchLotteries;
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

    return lottoMoney.getReward(totalWinningRewards);
  }

}