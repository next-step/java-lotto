package lotto;

import lotto.domain.LottoGame;
import lotto.domain.lotto.LottoImpl;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;
import lotto.utils.LottoGeneratorImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private static final String REGEX = ",";

    public static void main(String[] args) {
        int money = InputView.getMoney("구입금액을 입력해 주세요. ", new Scanner(System.in));
        LottoGame lottoGame = new LottoGame(money, new LottoGeneratorImpl());

        List<LottoImpl> lottos = lottoGame.createLottos();
        lottos.forEach(System.out::println);

        System.out.println();

        List<Integer> winningLottoNumbers =
            InputView.getWinningLottoNumbers("지난 주 당첨 번호를 입력해 주세요.",
                REGEX, new Scanner(System.in));


        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);
        lottoGame.play(winningLotto);

        OutputView.generateResult(lottos);
        System.out.println("당첨통계");
        System.out.println("-------");
        System.out.println(Rank.FOURCE.toString() + OutputView.getThreeMatchCount());
        System.out.println(Rank.THIRD.toString() + OutputView.getFourMatchCount());
        System.out.println(Rank.SECOND.toString() + OutputView.getFiveMatchCount());
        System.out.println(Rank.FIRST.toString() + OutputView.getSixMatchCount());

        System.out.println("총 수익률은 " + OutputView.getRewardPercent(lottoGame) + "입니다.");
        System.out.println("수익률이 1이면 본전");

    }
}
