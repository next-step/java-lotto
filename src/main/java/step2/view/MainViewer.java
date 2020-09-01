package step2.view;

import step2.domain.LottoNumbers;
import step2.domain.Lottos;
import step2.utils.BuyLotto;

public class MainViewer {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoneyAmount = InputClass.getUserIntInput();

        BuyLotto buyLotto = new BuyLotto(inputMoneyAmount);
        System.out.println(buyLotto.buy() + "개를 구매했습니다.");

        Lottos lottos = new Lottos(buyLotto.buy());
        lottos.getStream().forEach(lotto -> {
            System.out.println(lotto.getLotto().getNumbers().toString());
        });

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        LottoNumbers winnerNumbers = new LottoNumbers(InputClass.getUserStringInput());

        System.out.println("보너스볼을 입력해 주세요.");
        int inputBonusNumber = InputClass.getUserIntInput();

        ResultView resultView = new ResultView(inputMoneyAmount, lottos, winnerNumbers, inputBonusNumber);
        resultView.getResult();
    }
}
