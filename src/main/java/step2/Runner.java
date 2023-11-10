package step2;

import step2.domain.Lottos;
import step2.view.InputView;
import step2.view.ResultView;

import java.math.BigDecimal;

import static step2.domain.LottoNumberGenerator.lottoNumbers;
import static step2.domain.LottoStore.lottos;
import static step2.domain.LottoStore.numberOfLotto;
import static step2.util.BigDecimalUtil.stringToBigDecimal;

public class Runner {

    public static void main(String[] args) {
        BigDecimal price = stringToBigDecimal(InputView.price());
        int numberOfLotto = numberOfLotto(price);
        ResultView.printPurchaseMessage(numberOfLotto);

        Lottos lottos = lottos(lottoNumbers(numberOfLotto));
        ResultView.printLottos(lottos);
    }

}
