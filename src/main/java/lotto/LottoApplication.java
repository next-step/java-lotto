package lotto;

import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWiningNumbers;
import lotto.model.LottoRequestVO;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {
    LottoRequestVO lottoRequestVO = InputView.buyLotto();

    LottoTicket boughtLottoTicket = lottoRequestVO.getLottoTicket();
    LottoWiningNumbers winingNumbers = lottoRequestVO.getWiningNumbers();

    LottoStore store = LottoStore.open(winingNumbers)
            .exchange(boughtLottoTicket);

    ResultView.print(boughtLottoTicket, store);
  }
}
