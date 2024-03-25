package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

  private final int lottoPrice = 1000;
  private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
  private LottoList lottoList;

  public int createLotto(int totalMoney) {
    int lottoCount = getBuyableLottoCount(totalMoney);
    lottoList = new LottoList(generateLotto(lottoCount));
    return lottoCount;
  }

  public String getLottoResult(List<Integer> winningNumbers) {
    // TODO 구현 필요
    return null;
  }

  private int getBuyableLottoCount(int totalMoney) {
    return totalMoney / lottoPrice;
  }

  private List<Lotto> generateLotto(int count){
    return IntStream.range(0, count)
                  .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                  .collect(Collectors.toList());
  }
}
