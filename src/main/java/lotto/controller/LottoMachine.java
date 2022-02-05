package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public class LottoMachine {

    private static final LottoGenerator LOTTO_GENERATOR = new LottoGenerator();

    private LottoMachine() {
    }

    public static LottoTicket purchaseLotto(LottoCount lottoCount) {
        List<Lotto> lottos = IntStream.range(0, lottoCount.count())
            .mapToObj((i) -> new Lotto(generateLottoNumber()))
            .collect(Collectors.toList());
        return new LottoTicket(lottos);
    }

    private static List<LottoNumber> generateLottoNumber() {
        return LOTTO_GENERATOR.generateLotto()
            .stream()
            .sorted()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
