package lotto.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.ResultGroup;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    private static final LottoGenerator LOTTO_GENERATOR = new LottoGenerator();
    private static final String WINNING_LOTTO_DELIMITER = ", ";

    private LottoMachine() {
    }

    public static LottoTicket purchaseLotto(LottoCount lottoCount) {
        List<Lotto> lottos = IntStream.range(0, lottoCount.count())
            .mapToObj((i) -> new Lotto(generateLottoNumber()))
            .collect(Collectors.toList());
        return new LottoTicket(lottos);
    }

    public static ResultGroup getResult(LottoTicket lottoTicket, WinningLotto winningLotto) {
        return lottoTicket.getResult(winningLotto);
    }

    public static WinningLotto generateWinningLotto(String winningLottoLine) {
        List<LottoNumber> lottoNumbers = Arrays.stream(
                winningLottoLine.split(WINNING_LOTTO_DELIMITER))
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        String bonusBall = InputView.getBonusBall();
        int parseBonus = Integer.parseInt(bonusBall);
        lottoNumbers.add(new LottoNumber(parseBonus));
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

    private static List<LottoNumber> generateLottoNumber() {
        return LOTTO_GENERATOR.generateLotto()
            .stream()
            .sorted()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
