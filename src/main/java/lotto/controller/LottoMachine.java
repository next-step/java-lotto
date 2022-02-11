package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.Money;
import lotto.domain.ResultGroup;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lottogenerator.ManualLottoGenerator;
import lotto.domain.lottogenerator.RandomLottoGenerator;
import lotto.view.OutputView;

public class LottoMachine {

    private LottoMachine() {
    }

    public static LottoTicket purchaseLotto(LottoCount autoCount, List<String> manualLottos) {
        List<Lotto> lottos = manualLottos.stream()
            .map(str -> generateLotto(new ManualLottoGenerator(str)))
            .collect(Collectors.toList());
        lottos.addAll(IntStream.range(0, autoCount.count())
            .mapToObj((i) -> generateLotto(new RandomLottoGenerator()))
            .collect(Collectors.toList()));
        return new LottoTicket(lottos);
    }

    public static ResultGroup getResult(LottoTicket lottoTicket, WinningLotto winningLotto) {
        return lottoTicket.getResult(winningLotto);
    }

    public static WinningLotto generateWinningLotto(String winningLottoLine, String bonusBall) {
        return WinningLotto.of(winningLottoLine, bonusBall);
    }

    public static void showLottoCount(LottoCount manualCount, LottoCount autoCount) {
        OutputView.printLottoCount(manualCount.count(), autoCount.count());
    }

    public static void showLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.values()
            .stream()
            .map(Lotto::values)
            .forEach(LottoMachine::showEachLottoNumber);
    }

    public static void showResults(ResultGroup resultGroup, Money money) {
        OutputView.printResult(new ResultGroupDto(resultGroup));
        double profits = resultGroup.calculateProfits(money);
        OutputView.printProfits(profits);
    }

    private static void showEachLottoNumber(List<LottoNumber> lottoNumber) {
        OutputView.printEachLotto(lottoNumber);
    }

    private static Lotto generateLotto(LottoGenerator lottoGenerator) {
        return lottoGenerator.generateLotto();
    }
}
