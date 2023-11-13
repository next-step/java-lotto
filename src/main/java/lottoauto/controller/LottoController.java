package lottoauto.controller;

import lottoauto.domain.aggregate.Aggregator;
import lottoauto.domain.aggregate.WinnerBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private Aggregator aggregator;

    public LottoController(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    public WinnerBoard checkWinnerLotto(String winNumbersString) {
        List<Integer> winNumbers = extractWinningNumbers(winNumbersString);
        checkIsValidWinNumbers(winNumbers);

        return aggregator.checkWinnerLotto(winNumbers);
    }

    public double calculateEarningRate() {
        return aggregator.calculateEarningRate();
    }

    private List<Integer> extractWinningNumbers(String winNumbersString) {
        return Arrays.stream(winNumbersString.split(","))
                .map(strNumber -> {
                    int number = Integer.parseInt(strNumber.strip());
                    if (number > 45 || number < 1) {
                        throw new IllegalArgumentException("적절하지 않은 당첨 번호 입니다.");
                    }
                    return number;
                })
                .collect(Collectors.toList());
    }

    private void checkIsValidWinNumbers(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨번호는 6개의 숫자여야 합니다.");
        }

        if (hasDuplicatedNumber(winNumbers)) {
            throw new IllegalArgumentException("중복된 당첨번호를 작성할 수 없습니다.");
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> winNumbers) {
        List<Integer> checkedWinNumbers = new ArrayList<>(new HashSet<>(winNumbers));
        return checkedWinNumbers.size() != winNumbers.size();
    }

}
