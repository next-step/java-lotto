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

    public List<LottoNumber> pickSixNumbers() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> pickedNumbers = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(pickedNumbers);
        return pickedNumbers;
    }

    public boolean containWinNum(int winNum) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equalsWinNum(winNum));
    }

    public String toStringLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::toStringNumber)
                .collect(Collectors.joining(NUMBER_DELIMITER, RESULT_PREFIX, RESULT_SUFFIX));
    }
}
