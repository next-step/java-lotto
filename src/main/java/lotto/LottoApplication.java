package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.FixedDrawingStrategy;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.RandomDrawingStrategy;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  private static final int LOTTO_PRICE = 1_000;

  public static void main(String[] args) {
    InputView inputView = new InputView();

    int purchaseAmount = inputView.getPurchaseAmount();
    int ticketCount = purchaseAmount / LOTTO_PRICE;

    int passivityTicketCount = inputView.getPassivityTicketCount();
    int automaticTicketCount = ticketCount - passivityTicketCount;

    List<Lotto> lottos = new ArrayList<>();

    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    for (int i = 0; i < passivityTicketCount; i++) {
      List<Integer> passivityLottoNumbers = inputView.getPassivityLottoNumbers();
      lottos.add(new Lotto(new FixedDrawingStrategy(passivityLottoNumbers)));
    }

    for (int i = 0; i < automaticTicketCount; i++) {
      lottos.add(new Lotto(new RandomDrawingStrategy()));
    }

    //
    ResultView.showLottos(lottos, passivityTicketCount, automaticTicketCount);

    WinningLotto winningLotto = inputView.getWinningNumbers();
    LottoChecker lottoChecker = new LottoChecker()
        .calculateResults(lottos, winningLotto, purchaseAmount);

    ResultView.printResults(lottoChecker);

  }
}
