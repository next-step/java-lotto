package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;

public class LotteryDraw {

  private static final String SPLIT_MARK = ",";

  private Lotteries lotteries;

  private LottoMoney lottoMoney;

  public LotteryDraw(final LottoGameApplication gameApplication) {
    this.lottoMoney = gameApplication.lottoMoney;
    this.lotteries = gameApplication.getLotteriesInfo();
  }

  public Lotto inputWinningNumbers(String winningLottery) {
    return Lotto.getWinningLotto(splitWinningNumbers(winningLottery));
  }

  private List<Integer> splitWinningNumbers(final String winningLottery) {
    return Arrays.stream(winningLottery.trim().split(SPLIT_MARK))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public Map<Integer, List<Lotto>> matchLottoInfo(Lotto winLotto) {
    return lotteries.getInputMatchTotalInfo(createRatingInfo(),winLotto);
  }

  private Map<Integer, List<Lotto>> createRatingInfo() {
    Map<Integer, List<Lotto>> categoriesRank = new LinkedHashMap<>();

    categoriesRank.put(Rank.FIFTH.getCountOfMatch(), new ArrayList<>());
    categoriesRank.put(Rank.FOURTH.getCountOfMatch(), new ArrayList<>());
    categoriesRank.put(Rank.THIRD.getCountOfMatch(), new ArrayList<>());
    categoriesRank.put(Rank.FIRST.getCountOfMatch(), new ArrayList<>());
    categoriesRank.put(Rank.MISS.getCountOfMatch(), new ArrayList<>());

    return categoriesRank;
  }

  public double gradingScore(Map<Integer, List<Lotto>> result) {
    int sum = result.keySet().stream()
        .mapToInt(ratingNumber -> getCalculation(result, ratingNumber)).sum();
    return lottoMoney.getReward(sum);
  }

  private int getCalculation(final Map<Integer, List<Lotto>> result, final Integer ratingNumber) {
    return Operation.chooseOperation(Operation.MULTIPLE).calculation(result.get(ratingNumber).size(),
        Rank.matchRank(ratingNumber).getWinningMoney());
  }

}