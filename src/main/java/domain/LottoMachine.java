package domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LottoMachine {

  private final int lottoPrice = 1000;
  private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

  private final Map<Integer, Integer> prizeMap = Map.of(
      3, 5000,
      4, 50000,
      5, 1500000,
      6, 2000000000
  );
  private LottoList lottoList;

  public int createLotto(int totalMoney) {
    int lottoCount = getBuyableLottoCount(totalMoney);
    lottoList = new LottoList(lottoNumberGenerator, lottoCount);
    return lottoCount;
  }

  public List<String> getAllLottoList(){
    return lottoList.getLottoNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
  }

  public String getLottoResult(List<Integer> winningNumbers) {
    Set<Integer> winningNumberSet = new HashSet<>(winningNumbers);
    Map<Integer, Integer> result = lottoList.getLottoResult(winningNumberSet);
    return String.format("당첨 통계\n--------\n%s\n%s\n",getMatchCountString(result), getProfitRateString(getProfitRate(result)));
  }

  private int getBuyableLottoCount(int totalMoney) {
    return totalMoney / lottoPrice;
  }

  private String getMatchCountString(Map<Integer, Integer> result) {
    return prizeMap.entrySet().stream()
        .map(entry -> {
          int count = result.getOrDefault(entry.getKey(), 0);
          return String.format("%d개 일치 (%d원)- %d개", entry.getKey(), entry.getValue(), count);
        }).collect(Collectors.joining("\n"));
  }

  private String getProfitRateString(double profitRate) {
    return String.format("총 수익률은 %.2f입니다.%s", profitRate, profitRate >= 1 ? " -> 이익입니다." : " -> 손해입니다.");
  }

  private double getProfitRate(Map<Integer, Integer> result) {
    AtomicInteger totalPrize = new AtomicInteger();
    result.entrySet().stream()
        .filter(e -> e.getKey() >= 3)
        .forEach(entry -> totalPrize.addAndGet(prizeMap.get(entry.getKey()) * entry.getValue()));
    return new BigDecimal(totalPrize.get()).divide(new BigDecimal(lottoList.getLottoCount() * lottoPrice)).doubleValue();
  }
}
