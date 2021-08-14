package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private static final String SEPARATOR = ",";

    private final String[] lottoNumbers;

    public ManualLottoGenerator(String lottoNumbers) {
        this.lottoNumbers = lottoNumbers.split(SEPARATOR);
    }

    public ManualLottoGenerator(String... lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public LottoTicket generate() {
        List<LottoNumber> lottoNumbers = Arrays.stream(this.lottoNumbers)
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }
}
