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
    return new LottoResult(result, lottoList.getLottoCount() * lottoPrice);
  }

  private int getBuyableLottoCount(int totalMoney) {
    return totalMoney / lottoPrice;
  }

}
