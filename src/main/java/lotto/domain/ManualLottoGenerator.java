package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private final LottoTicket lottoTicket;

    public ManualLottoGenerator(String... lottoNumbers) {
        List<LottoNumber> lottoTicket = Arrays.stream(lottoNumbers)
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
        this.lottoTicket = new LottoTicket(lottoTicket);
    }

    @Override
    public LottoTicket generate() {
        return lottoTicket;
    }
}
