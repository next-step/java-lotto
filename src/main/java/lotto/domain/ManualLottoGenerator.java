package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ManualLottoGenerator implements LottoGenerator {

    private static final String SEPARATOR = ",";

    private final String[] lottoNumbers;

    public ManualLottoGenerator(final String lottoNumbers) {
        this.lottoNumbers = lottoNumbers.split(SEPARATOR);
    }

    public ManualLottoGenerator(final String... lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public LottoTicket generate() {
        List<LottoNumber> lottoNumberList = Arrays.stream(lottoNumbers)
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumberList);
    }
}
