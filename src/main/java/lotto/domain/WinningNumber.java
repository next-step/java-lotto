package lotto.domain;

import lotto.utils.LottoValidationUtils;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.CommonConstant.NUMBER_ZERO;

public class WinningNumber {

    private static final String INPUT_WINNING_NUMBER_DELIMITER = ", ";

    List<Integer> winningNumbers;

    public WinningNumber() {
        this.winningNumbers = new ArrayList<>();
    }

    public List<Integer> setWinningNumber(String winningNumber) {
        String[] winningNumberArray = new StringUtils(winningNumber).split(INPUT_WINNING_NUMBER_DELIMITER);
        LottoValidationUtils.invalidWinningNumberSizeException(winningNumberArray);
        isWinningNumberAdd(winningNumberArray);
        return winningNumbers;
    }

    private boolean isWinningNumberAdd(String[] winningNumberArray) {
        return this.winningNumbers.addAll(Arrays.stream(winningNumberArray)
                .map(number -> new StringUtils(number).toInt())
                .sorted()
                .collect(Collectors.toList()));
    }

    public int findLottoTicket(List<Integer> winningNumbers, LottoTicket lottoTicket, int matchCount) {
        for (int j = NUMBER_ZERO; j < lottoTicket.count(); j++) {
            matchCount = containsLottoNumber(winningNumbers, matchCount, lottoTicket, j);
        }
        return matchCount;
    }

    private int containsLottoNumber(List<Integer> winningNumbers, int matchCount, LottoTicket lottoTicket, int j) {
        if (winningNumbers.contains(lottoTicket.getLottoTicketNumber(j))) {
            matchCount++;
        }
        return matchCount;
    }

}
