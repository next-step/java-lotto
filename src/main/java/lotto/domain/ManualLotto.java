package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLotto extends Lotto {

    public ManualLotto(List<LottoNumber> lottoNumbers) {
        super(convertToSet(lottoNumbers));
    }

    public static ManualLotto of(List<Integer> numbers) {
        return new ManualLotto(numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    @Override
    public LottoType getLottoType() {
        return LottoType.MANUAL;
    }
}
