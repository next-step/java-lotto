package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoDto {

    private final List<Integer> lottoNumbers;

    public LottoDto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoDto valueOf(Lotto lotto) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (LottoNumber lottoLotto : lotto.getLotto()) {
            lottoNumbers.add(lottoLotto.getLottoNumber());
        }
        return new LottoDto(lottoNumbers);
    }

    public Lotto toLotto() {
        List<LottoNumber> lottoNumbers = createLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    private List<LottoNumber> createLottoNumbers() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
