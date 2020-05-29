package lotto.domain.lotto;

import lotto.domain.generator.NumberGenerator;
import lotto.domain.number.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final List<LottoNumbers> lottoNumbers;

    public LottoTicket(int lottoCount, NumberGenerator generator) {
        this.lottoNumbers = createLottoTicket(lottoCount, generator);
    }

    private List<LottoNumbers> createLottoTicket(int lottoCount, NumberGenerator generator) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new LottoNumbers(generator))
                .collect(Collectors.toList());

    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }
}
