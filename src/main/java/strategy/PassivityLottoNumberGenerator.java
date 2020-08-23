package strategy;

import domain.LottoNumber;
import util.SplitUtil;

import java.util.List;
import java.util.stream.Collectors;

public class PassivityLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<LottoNumber> generator(String numbers) {
        List<Integer> lottoNumbers = SplitUtil.splitToNumber(numbers);

        return lottoNumbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }
}
