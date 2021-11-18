package step2.view;

import java.util.List;
import java.util.stream.Collectors;
import step2.model.Lotto;
import step2.model.LottoNumber;

public class LottoDTO {

    private List<Integer> lottoNumbers;

    public LottoDTO(Lotto lotto) {
        lottoNumbers = lotto.getLottoNumbers()
            .getLottoNumbers()
            .stream()
            .map(LottoNumber::getLottoNumber)
            .collect(Collectors.toList());
    }
}
