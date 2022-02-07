package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.ResultGroup;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

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
        List<LottoNumber> lottoNumbers = Arrays.stream(winningLottoLine.split(WINNING_LOTTO_DELIMITER))
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        String bonusBall = InputView.getBonusBall();
        int parseBonus = Integer.parseInt(bonusBall);
        lottoNumbers.add(new LottoNumber(parseBonus));
        return new WinningLotto(lottoNumbers);
    }

    private static List<LottoNumber> generateLottoNumber() {
        return LOTTO_GENERATOR.generateLotto()
            .stream()
            .sorted()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
