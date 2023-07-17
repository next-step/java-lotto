package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {

    private static final int LOTTO_RANGE_START = 1;
    private static final int LOTTO_RANGE_END = 45;
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = 6;

    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        for (int number = LOTTO_RANGE_START; number <= LOTTO_RANGE_END; number++) {
            lottoNumbers.add(new LottoNumber(number));
        }
    }

    @Override
    public List<LottoNumber> generate() {
        return selectLottoNumbers(shuffleLottoNumber());
    }

    private List<LottoNumber> shuffleLottoNumber() {
        List<LottoNumber> copyLottoNumbers = copyLottoNumbers();
        Collections.shuffle(copyLottoNumbers);
        return copyLottoNumbers;
    }

    private List<LottoNumber> copyLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    private List<LottoNumber> selectLottoNumbers(final List<LottoNumber> copyLottoNumbers) {
        return copyLottoNumbers.subList(FROM_INDEX, TO_INDEX);
    }


}
