package lotto;

import lotto.domain.LottoStore;
import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;
import lotto.utils.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private static final String REGEX = ",";

    public static void main(String[] args) {
        int money = InputView.getMoney("구입금액을 입력해 주세요. ", new Scanner(System.in));
        LottoStore lottoStore = new LottoStore(new RandomLottoGenerator());

        List<BasicLotto> lottos = lottoStore.buyLottos(money);
        lottos.forEach(System.out::println);

        System.out.println();

        List<Integer> winningLottoNumbers =
            InputView.getWinningLottoNumbers("지난 주 당첨 번호를 입력해 주세요.",
                REGEX, new Scanner(System.in));


        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        OutputView.generateResult(lottos, winningLotto);
        System.out.println("당첨통계");
        System.out.println("-------");
        System.out.println(Rank.FOURCE.toString() + OutputView.getThreeMatchCount());
        System.out.println(Rank.THIRD.toString() + OutputView.getFourMatchCount());
        System.out.println(Rank.SECOND.toString() + OutputView.getFiveMatchCount());
        System.out.println(Rank.FIRST.toString() + OutputView.getSixMatchCount());

        System.out.println("총 수익률은 " + OutputView.getRewardPercent(money) + "입니다.");
        System.out.println("수익률이 1이면 본전");

    }
}
