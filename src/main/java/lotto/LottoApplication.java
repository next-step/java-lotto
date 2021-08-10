package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {

        //구입 금액 입력
        Money money = new Money(InputView.inputPurchaseAmount());

        //구입 갯수만큼 로또 번호 생성
        LottoNumbers lottoNumbers = new LottoNumbers();
        Lottos lottos = new Lottos(money, lottoNumbers);

        //구입 결과 출력
        OutputView.printPurchase(lottos);

        //당첨 번호 입력
        lottoNumbers.setWinningNumbers(InputView.inputWinningNumbers());

        //당첨 번호 비교 및 결과 출력
        lottos.checkLottosWinning(lottoNumbers);
        OutputView.printLottosResult(lottos);

    }
}
