package step02.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import step02.domain.Lotto;
import step02.domain.LottoNumber;

public class LottoDto {

    private final List<Integer> lotto = new ArrayList<>();

    public LottoDto(List<Integer> lotto) {
        this.lotto.addAll(lotto);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public static LottoDto from(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getValue().stream()
            .map(LottoNumber::getValue)
            .collect(Collectors.toList());

        return new LottoDto(lottoNumbers);
    }
}
