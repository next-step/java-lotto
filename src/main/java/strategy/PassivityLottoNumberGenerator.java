package strategy;

import domain.LottoNumber;
import util.SplitUtil;

import java.util.List;
import java.util.stream.Collectors;

public class PassivityLottoNumberGenerator implements LottoNumberGenerator {

    public static final String DELIMITER = ",";

    @Override
    public List<LottoNumber> generator(String numbers) {
        List<Integer> lottoNumbers = SplitUtil.splitToNumber(numbers, DELIMITER);

        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
