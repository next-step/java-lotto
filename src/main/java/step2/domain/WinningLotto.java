package step2.domain;

import static step2.Constants.COMMA;
import static step2.Constants.EMPTY_STRING;
import static step2.Constants.REX_WHITE_SPACE_IN_STRING;
import static step2.domain.LottoGenerator.LOTTO_SELECTION_COUNT;
import static step2.view.ErrorMessages.INVALID_WINNING_NUMBERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

public class WinningLotto extends AbstractLotto {

    private String winningNumberString;

    public WinningLotto(String winningNumberString) throws IllegalArgumentException {
        this.winningNumberString = winningNumberString;
        validateWinningNumbers();

        List<String> parsedWinningNumbers = parseWinningNumbers(this.winningNumberString);
        super.setLottoNumbers(convertStringToIntegerList(parsedWinningNumbers));
    }

    @Override
    public List<Integer> getLottoNumbers() throws IllegalArgumentException {
        return super.getLottoNumbers();
    }

    public void validateWinningNumbers()
        throws IllegalArgumentException {

        List<String> parsedWinningNumbers = parseWinningNumbers(winningNumberString);

        if (CollectionUtils.size(parsedWinningNumbers) != LOTTO_SELECTION_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }

        if (parsedWinningNumbers.stream()
            .anyMatch(number -> !Character.isDigit(number.charAt(0)))) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }
    }

    private List<String> parseWinningNumbers(String winningNumbers)
        throws IllegalArgumentException {

        String[] parsedWinningNumbers = winningNumbers
            .replaceAll(REX_WHITE_SPACE_IN_STRING, EMPTY_STRING)
            .split(COMMA);

        return Arrays.asList(parsedWinningNumbers);
    }

    private List<Integer> convertStringToIntegerList(List<String> stringList) {
        List<Integer> result = new ArrayList<>();
        try {
            stringList.stream().forEach(string -> result.add(Integer.parseInt(string)));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return result;
    }


}
