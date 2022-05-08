package study.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static study.step2.domain.LottoNumbers.LOTTO_BEGIN_NUMBER;
import static study.step2.domain.LottoNumbers.LOTTO_END_NUMBER;

public class LottoWinningNumber {
    private static final String REGEX_LAST_WEEK_NUMBER_SPLIT = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> lottoWinningNumber;

    public LottoWinningNumber(String lottoWinningNumber) {
        List<Integer> lastWeekLottoNumberList =
                Arrays.stream(lottoWinningNumber.split(REGEX_LAST_WEEK_NUMBER_SPLIT))
                        .map(s -> s.trim())
                        .collect(Collectors.toList())
                        .stream()
                        .map(s -> Integer.parseInt(s))
                        .collect(Collectors.toList());
        if (isInvalid(lastWeekLottoNumberList)) {
            throw new IllegalArgumentException("당첨번호를 올바르게 입력해주세요.");
        }
        this.lottoWinningNumber = lastWeekLottoNumberList;
    }

    public List<Integer> getLottoWinningNumber() {
        return lottoWinningNumber;
    }

    private static boolean isInvalid(List<Integer> lastWeekLottoNumberList) {
        if (lastWeekLottoNumberList.size() != LOTTO_NUMBER_COUNT) {
            return true;
        }
        if (lastWeekLottoNumberList.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            return true;
        }
        if (lastWeekLottoNumberList.stream().anyMatch(i->isLottoNumber(i))) {
            return true;
        }
        return false;
    }

    private static boolean isLottoNumber(int lottoNumber) {
        return (LOTTO_BEGIN_NUMBER > lottoNumber) || (LOTTO_END_NUMBER < lottoNumber);
    }
}
