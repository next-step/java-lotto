package autolotto.dto;

import autolotto.machine.lotto.Lotto;
import autolotto.machine.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;


public class LottoDTO {
    public final List<Integer> numbers;

    public LottoDTO(List<Integer> lottoNumbers) {
        this.numbers = new ArrayList<>(lottoNumbers);
    }

    public static LottoDTO from(Lotto lotto) {
        return new LottoDTO(
                lotto.lottoNumbers().stream()
                        .map(LottoNumber::value)
                        .collect(toList()));
    }

    public List<Integer> numbers() {
        return new ArrayList<>(this.numbers);
    }
}
