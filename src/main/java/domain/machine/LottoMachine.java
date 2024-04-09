package domain.machine;

import domain.lotto.Lotto;
import domain.lotto.LottoList;
import domain.lotto.vo.LottoNumber;
import domain.lotto.vo.LottoResult;
import domain.lotto.vo.WinNumbers;
import java.util.*;

public class LottoMachine {

  private static final int lottoPrice = 1000;
  private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
  private final LottoList lottoList = new LottoList();

  public int createLotto(int totalMoney) {
    int lottoCount = getBuyableLottoCount(totalMoney);
    lottoList.generateAutoLotto(lottoNumberGenerator, lottoCount);
    return lottoCount;
  }


  public int createLotto(int totalMoney, List<List<LottoNumber>> manualLottoNumbers) {
    int lottoCount = getBuyableLottoCount(totalMoney);

    manualLottoNumbers.forEach(lottoList::generateManualLotto);
    lottoList.generateAutoLotto(lottoNumberGenerator, lottoCount - manualLottoNumbers.size());
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
