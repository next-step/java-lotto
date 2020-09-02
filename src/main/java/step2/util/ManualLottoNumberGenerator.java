package step2.util;

import step2.domain.lotto.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumberGenerator implements NumberGenerator {

    @Override
    public List<LottoNumber> generate(String numbers) {
        List<Integer> lottoNumbers = SplitUtil.castingToList(SplitUtil.splitNumber(numbers));

        return lottoNumbers
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
