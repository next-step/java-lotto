package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class LottoService {
  private final LottoGenerator lottoGenerator;

  public LottoService() {
    this.lottoGenerator = new LottoGenerator();
  }

  public List<Lotto> buyLottos(int money) {
    return lottoGenerator.generate(money);
  }

  public LottoResult calculateResult(
      List<Lotto> lottos, Lotto winningLotto, LottoNumber bonusNumber) {
    LottoResult lottoResult = new LottoResult();

    for (Lotto lotto : lottos) {
      int matchCount = lotto.countMatchingNumbers(winningLotto);
      boolean bonusMatch = lotto.containsNumber(bonusNumber.getNumber());

      Rank rank = Rank.valueOf(matchCount, bonusMatch);
      lottoResult.addRank(rank);
    }

    return lottoResult;
  }
}
