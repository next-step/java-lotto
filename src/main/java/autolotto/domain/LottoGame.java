package autolotto.domain;

import autolotto.strategy.LottoNumberGenerator;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGame {

    private final int ticketsCount;
    private final int manualLottoCount;
    private final List<Lotto> manualLotto;
    private LottoNumberGenerator lottoNumberGenerator;

    public LottoGame(int ticketsCount, List<Lotto> manualLotto, LottoNumberGenerator lottoNumberGenerator) {
        this.ticketsCount = ticketsCount;
        this.manualLottoCount = manualLotto.size();
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.manualLotto = manualLotto;
    }

    private List<Lotto> getAutoLottoTickets() {
        return Optional.ofNullable(IntStream.range(0, this.ticketsCount - this.manualLottoCount)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generateNumbers()))
                .collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    private List<Lotto> getManualLottoTickets() {
        return this.manualLotto;
    }

    public List<Lotto> getLottos() {
        List<Lotto> manualLottos = getManualLottoTickets();
        List<Lotto> autoLottos = getAutoLottoTickets();
        List<Lotto> combinedLottos = Stream.concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
        return combinedLottos;
    }


}
