package domain;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class LottoMachine {

  private final int lottoPrice = 1000;
  private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
  private LottoList lottoList;

  public int createLotto(int totalMoney) {
    int lottoCount = getBuyableLottoCount(totalMoney);
    lottoList = new LottoList(lottoNumberGenerator, lottoCount);
    return lottoCount;
  }

  public List<Lotto> getAllLottoList(){
    return lottoList.getLottoNumbers();
  }

  public LottoResult getLottoResult(WinNumbers winningNumbers) {
    Map<Integer, Integer> result = lottoList.getLottoResult(winningNumbers);
    return new LottoResult(findWinningPrizeMap(result), getProfitRate(result));
  }

  private int getBuyableLottoCount(int totalMoney) {
    return totalMoney / lottoPrice;
  }

  private Map<Integer, Integer> findWinningPrizeMap(Map<Integer, Integer> result) {
    Map<Integer, Integer> prizeMap = new HashMap<>(4);
    IntStream.range(3,7).forEach(count -> prizeMap.put(count, result.getOrDefault(count, 0)));
    return prizeMap;
  }

  private double getProfitRate(Map<Integer, Integer> result) {
    AtomicInteger totalPrize = new AtomicInteger();
    result.entrySet().stream()
        .filter(e -> e.getKey() >= 3)
        .forEach(entry -> totalPrize.addAndGet(Prize.findPrizeMoneyByCount(entry.getKey()) * entry.getValue()));
    return new BigDecimal(totalPrize.get()).divide(new BigDecimal(lottoList.getLottoCount() * lottoPrice)).doubleValue();
  }
}
