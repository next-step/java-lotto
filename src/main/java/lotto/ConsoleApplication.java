package lotto;

import lotto.domain.LottoStore;
import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.utils.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.LottoResult;

import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private static final String REGEX = ",";

    public static void main(String[] args) {
        int money = InputView.getMoney("구입금액을 입력해 주세요. ", new Scanner(System.in));
        LottoStore lottoStore = new LottoStore(new RandomLottoGenerator());

        List<BasicLotto> lottos = lottoStore.buyLottos(money);
        LottoResult.printLottos(lottos);

        List<Integer> winningLottoNumbers =
            InputView.getWinningLottoNumbers("지난 주 당첨 번호를 입력해 주세요.",
                REGEX, new Scanner(System.in));


        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        LottoResult.generate(lottos, winningLotto);
        LottoResult.getRewardPercent(money);
    }
}
