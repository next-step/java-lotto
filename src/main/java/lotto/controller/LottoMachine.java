package lotto.controller;

import java.util.Arrays;
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

    private static final String WINNING_LOTTO_DELIMITER = ",";

    private LottoMachine() {
    }

    public static LottoTicket purchaseLotto(LottoCount autoCount, List<String> manualLottos) {
        List<Lotto> lottos = manualLottos.stream()
            .map(str -> generateLottoNumber(new ManualLottoGenerator(str)))
            .map(Lotto::new)
            .collect(Collectors.toList());
        lottos.addAll(IntStream.range(0, autoCount.count())
            .mapToObj((i) -> new Lotto(generateLottoNumber(new RandomLottoGenerator())))
            .collect(Collectors.toList()));
        return new LottoTicket(lottos);
    }

    public static ResultGroup getResult(LottoTicket lottoTicket, WinningLotto winningLotto) {
        return lottoTicket.getResult(winningLotto);
    }

    public static WinningLotto generateWinningLotto(String winningLottoLine, String bonusBall) {
        List<LottoNumber> lottoNumbers = Arrays.stream(
                winningLottoLine.split(WINNING_LOTTO_DELIMITER))
            .map(String::trim)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        lottoNumbers.add(new LottoNumber(bonusBall));
        return new WinningLotto(lottoNumbers);
    }

    public static void showLottoCount(LottoCount lottoCount) {
        OutputView.printLottoCount(lottoCount.count());
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

    private static List<LottoNumber> generateLottoNumber(LottoGenerator lottoGenerator) {
        return lottoGenerator.generateLotto()
            .stream()
            .sorted()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
