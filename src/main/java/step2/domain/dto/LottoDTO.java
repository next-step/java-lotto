package step2.domain.dto;

import step2.domain.Lotto;
import step2.domain.LottoNo;

import java.util.List;
import java.util.stream.Collectors;

public class LottoDTO {

    private List<LottoNo> numbers;

    public List<Integer> getNumbers() {
        return this.numbers.stream()
                .map(lottoNo -> lottoNo.getNumber())
                .collect(Collectors.toList());
    }

    protected LottoDTO(Lotto lotto) {
        this.numbers = lotto.getNumbers();
    }

    public static LottoDTO from(Lotto lotto) {
        return new LottoDTO(lotto);
    }

}
