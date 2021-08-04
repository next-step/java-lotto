package lotto.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.strategy.GenerateLottoNumber;
import lotto.strategy.RealGenerateLottoNumber;

public class LotteryDraw {

  private int money;

  private Lotties lotties;

  private static final String SPLIT_MARK = ",";

  private static final int EACH_LOTTO_COST = 1000;

  private static final int START = 1;

  private static final int END = 46;

  private static final String PROFIT_RATE_FORMAT = "#.##";

  private static final int INT_ZERO = 0;

  private static final int LITMIT_MATCH_NUMBER = 3;

  GenerateLottoNumber generateLottoNumber = new RealGenerateLottoNumber(START, END);

  public LotteryDraw(int money) {
    this.money = money;
    buyLotties();
  }

  public LotteryDraw() {

  }

  public void checkInputValue() {
    if (Operation.chooseOperation("%").calculation(money, EACH_LOTTO_COST) != 0) {
      throw new RuntimeException("금액을 정상적으로 입력해주세요.");
    }
  }

  public int getNumberOfLotto() {
    return Operation.chooseOperation("/").calculation(money, EACH_LOTTO_COST);
  }

  public void buyLotties() {
    checkInputValue();
    lotties = new Lotties(getNumberOfLotto(), generateLottoNumber);
    System.out.println(lotties.getLotties().size()+"개를 구매했습니다.");
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

    categoriesRank.remove(0);

    return categoriesRank;
  }

  private int matchLottoRating(Lotties lotties, Lotto winLotto, Lotto lotty) {
    int matchLotties = lotties.getMatchLotties(lotty, winLotto);
    if (matchLotties < LITMIT_MATCH_NUMBER) {
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

    return format.format((double) totalWinningRewards / (double) money);
  }
}