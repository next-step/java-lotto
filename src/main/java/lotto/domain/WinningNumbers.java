package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WinningNumbers {
    private static final String winningNumbersTextSplitRegex = ",";
    private Set<LottoNumber> winningNumbers;

    /*public WinningNumbers(Integer[] winningNumbers) {
        throwInValidWinningNumbers(winningNumbers);
        this.winningNumbers = parseWinningNumbers(winningNumbers);
    }

    public WinningNumbers(String winningNumbersText) {
        String[] textNumbers = winningNumbersText.split(winningNumbersTextSplitRegex);
        Integer[] resultNumbers = new Integer[textNumbers.length];
        for (int i = 0; i < textNumbers.length; i++) {
            resultNumbers[i] = Integer.parseInt(textNumbers[i]);
        }

        throwInValidWinningNumbers(resultNumbers);
        this.winningNumbers = parseWinningNumbers(resultNumbers);
    }

    private Set<LottoNumber> parseWinningNumbers(Integer[] numbers) {
        Set<LottoNumber> resultNumbers = new HashSet<>();
        for (int number : numbers) {
            resultNumbers.add(new LottoNumber(number));
        }

        return resultNumbers;
    }

    public WinningType findWinningType(LottoTicket lottoTicket) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoTicket.toArray()) {
            matchCount += contains(lottoNumber);
        }

        return WinningType.of(matchCount);
    }

    private int contains(LottoNumber lottoNumber) {
        if (this.winningNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    void throwInValidWinningNumbers(Integer[] winningNumbers) {
        //로또 넘버 길이 체크
        if (winningNumbers.length != LottoTicket.LOTTO_NUMBERS_LENGTH ) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_LENGTH.getErrorMessage());
        }

        //로또 넘버 중복 체크
        if (new HashSet<Integer>(Arrays.asList(winningNumbers)).size() < LottoTicket.LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_LOTTO_NUMBER.getErrorMessage());
        }
    }*/

}
