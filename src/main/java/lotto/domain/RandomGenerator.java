package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomGenerator implements LottoNumberGenerator {
    private static final List<LottoNumber> referenceNumbers = new ArrayList<>();

    static {
        for (int i = LottoConstant.LOTTO_FIRST_NUMBER; i <= LottoConstant.LOTTO_LAST_NUMBER; i++) {
            referenceNumbers.add(new LottoNumber(i));
        }
    }

    @Override
    public List<LottoNumber> extractLottoNumber() {
        Collections.shuffle(referenceNumbers);

        return referenceNumbers.subList(LottoConstant.LOTTO_SIZE_MIN, LottoConstant.LOTTO_SIZE_MAX)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
