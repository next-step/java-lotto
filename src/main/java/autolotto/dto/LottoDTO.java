package autolotto.dto;

import autolotto.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoDTO {
    public final List<Integer> numbers;

    public LottoDTO(List<Integer> lottoNumbers) {
        this.numbers = new ArrayList<>(lottoNumbers);
    }

    public static LottoDTO from(Lotto lotto) {
        return new LottoDTO(lotto.lottoNumbers());
    }

    public List<Integer> numbers() {
        return new ArrayList<>(this.numbers);
    }
}
