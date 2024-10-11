package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int LIMIT_WINNING_NUMBER = 45;
    private final static String WINNING_NUMBERS_SEPERATOR = ", ";

    private final List<Integer> winningNumbers;

    public WinningNumbers(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.validateNumbers();
    }

    public static WinningNumbers create(final String numbers){
        return new WinningNumbers(createNumbers(numbers));
    }

    private static List<Integer> createNumbers(String numbers) {
        String[] splitNumbers = splitNumbers(numbers);
        List<Integer> lottoNumbers = new ArrayList<Integer>();

        for (String number: splitNumbers) {
            int lottoNumber = parseInt(number);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private static String[] splitNumbers(String numbers) {
        return numbers.split(WINNING_NUMBERS_SEPERATOR);
    }

    private static int parseInt(String number) {
        int lottoNumber;
        try{
            lottoNumber = Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력 가능합니다");
        }
        return lottoNumber;
    }

    //region [validateNumbers]
    private void validateNumbers() {
        validNumberCount(winningNumbers);
        validNumberRange(winningNumbers);
        duplicateNumber(winningNumbers);
    }

    private void validNumberCount(List<Integer> numbers) {
        if(numbers.size() != WINNING_NUMBER_COUNT){
            throw new IllegalArgumentException("당첨 번호를 6개 입력하세요");
        }
    }

    private void validNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if(isNonValidNumber(number)){
                throw new IllegalArgumentException("1-45범위 내의 당첨 번호를 입력하세요");
            }
        }
    }

    private boolean isNonValidNumber(int lottoNumber) {
        return lottoNumber <= 0 || lottoNumber > LIMIT_WINNING_NUMBER;
    }

    private void duplicateNumber(List<Integer> lottoNumbers) {
        long count = lottoNumbers.stream()
                .distinct()
                .count();

        if(count < WINNING_NUMBER_COUNT){
            throw new IllegalArgumentException("당첨 번호가 중복됐습니다");
        }
    }
    //endregion

    public int matchWinningNumber(Lotto lotto) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            if(lotto.hasNumber(winningNumber)) matchCount++;
        }
        return matchCount;
    }
}
