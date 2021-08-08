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

  public LotteryDraw() {
  }

  public LotteryDraw(final Lotteries lotteries, final LottoMoney lottoMoney) {
    this.lottoMoney = lottoMoney;
    this.lotteries = lotteries;
  }

  public Lotto inputWinningNumbers(String winningLottery) {
    return Lotto.getWinningLotto(splitWinningNumbers(winningLottery));
  }

  private List<Integer> splitWinningNumbers(final String winningLottery) {
    return Arrays.stream(winningLottery.trim().split(SPLIT_MARK))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public Map<Rank, List<Lotto>> matchLottoInfo(Lotto winLotto) {
    return lotteries.getInputMatchTotalInfo(createRatingInfo(),winLotto);
  }

  private Map<Rank, List<Lotto>> createRatingInfo() {
    Map<Rank, List<Lotto>> categoriesRank = new LinkedHashMap<>();

    categoriesRank.put(Rank.FIFTH, new ArrayList<>());
    categoriesRank.put(Rank.FOURTH, new ArrayList<>());
    categoriesRank.put(Rank.THIRD, new ArrayList<>());
    categoriesRank.put(Rank.FIRST, new ArrayList<>());
    categoriesRank.put(Rank.MISS, new ArrayList<>());

    return categoriesRank;
  }

  public double gradingScore(Map<Rank, List<Lotto>> result) {
    int sum = result.keySet().stream()
        .mapToInt(ratingNumber -> getCalculation(result, ratingNumber.getCountOfMatch())).sum();
    return lottoMoney.getReward(sum);
  }

  private int getCalculation(final Map<Rank, List<Lotto>> result, final Integer ratingNumber) {
    return Operation.chooseOperation(Operation.MULTIPLE)
        .calculation(result.get(Rank.matchRank(ratingNumber)).size(), Rank.matchRank(ratingNumber).getWinningMoney());
  }

}