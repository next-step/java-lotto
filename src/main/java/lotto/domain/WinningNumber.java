package lotto.domain;

import lotto.utils.LottoValidationUtils;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber extends LottoTicket {

    private static final String INPUT_WINNING_NUMBER_DELIMITER = ", ";

    List<Integer> winningNumbers;

    public WinningNumber() {
        super();
        this.winningNumbers = new ArrayList<>();
    }

    public List<Integer> setWinningNumber(String winningNumber) {
        String[] winningNumberArray = new StringUtils(winningNumber).split(INPUT_WINNING_NUMBER_DELIMITER);
        LottoValidationUtils.invalidWinningNumberSizeException(winningNumberArray);
        isWinningNumberAdd(winningNumberArray);
        validateLottoRange(winningNumbers);
        return winningNumbers;
    }

    private boolean isWinningNumberAdd(String[] winningNumberArray) {
        return this.winningNumbers.addAll(Arrays.stream(winningNumberArray)
                .map(number -> new StringUtils(number).toInt())
                .sorted()
                .collect(Collectors.toList()));
    }

    public static boolean isContainsBonusNumber(List<Integer> lottoTicket, int bonusNumber) {
        return (lottoTicket.contains(bonusNumber));
    }

}
