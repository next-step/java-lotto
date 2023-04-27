package step2.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final String NUMBER_DELIMITER = ", ";

    private static final String RESULT_PREFIX = "[";

    private static final String RESULT_SUFFIX = "]";

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void shuffleNumbers() {
        Collections.shuffle(lottoNumbers);
    }

    public List<LottoNumber> pickSixNumbers() {
        List<LottoNumber> pickedNumbers = new ArrayList<>(this.lottoNumbers.subList(0, 6));
        Collections.sort(pickedNumbers);
        return pickedNumbers;
    }

    public boolean containWinNum(int winNum) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (lottoNumber.equalsWinNum(winNum)) {
                return true;
            }
        }
        return false;
    }

    public String toStringLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::toStringNumber)
                .collect(Collectors.joining(NUMBER_DELIMITER, RESULT_PREFIX, RESULT_SUFFIX));
    }
}
