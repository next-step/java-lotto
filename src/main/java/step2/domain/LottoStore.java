package step2.domain;

import step2.domain.dto.LottoRequest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoStore {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoStore() {
        this.lottoNumberGenerator = new LottoNumberGenerator();
    }

    public Lottos lottos(LottoRequest request) {
        List<LottoNumbers> manualLottoNumbers = lottoNumberGenerator.lottoNumbers(request.manualNumbers());
        List<LottoNumbers> automaticLottoNumbers = lottoNumberGenerator.lottoNumbers(request.automaticCount());

        return lottos(Stream.concat(manualLottoNumbers.stream(), automaticLottoNumbers.stream())
            .collect(Collectors.toList()));
    }

    private Lottos lottos(List<LottoNumbers> lottoNumbers) {
        return lottoNumbers.stream()
            .map(Lotto::new)
            .collect(collectingAndThen(toList(), Lottos::new));
    }

}
