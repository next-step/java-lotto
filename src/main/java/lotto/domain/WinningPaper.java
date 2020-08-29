package lotto.domain;

import lotto.context.Error;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningPaper {
    private final Integer MIN_LOTTO_NUMBER = 1;
    private final Integer MAX_LOTTO_NUMBER = 45;
    private final List<Integer> winningNumbers;

    WinningPaper(String winningLottoNumbers) {
        List<Integer> numberList = makeNmbersAsList(winningLottoNumbers);
        vaildList(numberList);
        this.winningNumbers = numberList;
    }

    private List makeNmbersAsList(String winningLottoNumbers) {
        return Arrays.stream(winningLottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void vaildList(List<Integer> numberList) {
        if (numberList.stream()
                .filter(number -> number <  MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
                .count() > 0) {
            throw new IllegalArgumentException(Error.ERROR_WINNING_NUMBER.getMsg());
        }
    }

    Integer getMatchCount(List<Integer> lottoNumber) {
        return (int) lottoNumber.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
