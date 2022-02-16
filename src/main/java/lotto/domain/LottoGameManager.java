package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.machine.LottoGenerator;

public class LottoGameManager {

    private static final int ONE = 1;

    public static List<Lotto> getLottosByAuto(LottoGenerator lottoGenerator, final int ticketCount) {
        return IntStream.rangeClosed(ONE, ticketCount)
            .mapToObj(index -> lottoGenerator.get().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()))
            .map(Lotto::new)
            .collect(Collectors.toList());
    }

    public static List<Lotto> getLottosByManual(List<List<Integer>> lottoNumbers) {
        return LottoSupplier.makeManualLotto(lottoNumbers);
    }
}
