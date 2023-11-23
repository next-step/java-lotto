package lotto.dto;

import java.util.ArrayList;
import java.util.List;
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

    public List<Integer> toLottoNumbers() {
        return this.lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
