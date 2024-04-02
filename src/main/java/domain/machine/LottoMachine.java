package domain.machine;

import domain.lotto.Lotto;
import domain.lotto.LottoList;
import domain.lotto.vo.LottoResult;
import domain.lotto.vo.WinNumbers;
import java.util.*;

public class LottoMachine {

  private static final int lottoPrice = 1000;
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
