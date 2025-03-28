package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumberGenerator implements LottoNumberGenerator {
    private final List<LottoNumber> lottoNumbers;

    public ManualLottoNumberGenerator(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        this.lottoNumbers = lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> generate() {
        return this.lottoNumbers;
    }
}
