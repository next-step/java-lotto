package step2.model.lotto;

import java.util.Collections;
import java.util.List;

public class LottoNos {

  private List<LottoNo> lottoNoList;

  public LottoNos(List<LottoNo> lottoNoList) {
    Collections.shuffle(lottoNoList);
    Collections.sort(lottoNoList);

    this.lottoNoList = lottoNoList;
  }

  public boolean hasLottoNo(LottoNo lottoNo) {
    return lottoNoList.contains(lottoNo);
  }

  public LottoNo getLottoNos(int index) {
    return lottoNoList.get(index);
  }

  public int getLottoNosSize() {
    return lottoNoList.size();
  }
}
