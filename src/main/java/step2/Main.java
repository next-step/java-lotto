package step2;

import step2.domain.Lotto;
import step2.domain.LottoResult;
import step2.domain.Lottos;
import step2.io.LottoInputView;
import step2.io.LottoOutputView;

public class Main {
    public static void main(String[] args) {
        LottoOutputView.println("구입금액을 입력해 주세요.");
        final Lottos lottos = LottoInputView.buyLotto();
        LottoOutputView.printBuyResult(lottos);

        LottoOutputView.println("지난 주 당첨 번호를 입력해 주세요.");
        final Lotto winningLotto = LottoInputView.winningLotto();
        final LottoResult lottoResult = LottoResult.builder()
                                                   .winningLotto(winningLotto)
                                                   .addLottos(lottos)
                                                   .build();
        LottoOutputView.printResult(lottoResult);
    }
}
