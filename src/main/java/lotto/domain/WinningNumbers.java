package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int LIMIT_WINNING_NUMBER = 45;
    private final static String WINNING_NUMBERS_SEPERATOR = ", ";

    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(final int... winningNumbers) {
        this(convertIntToLottoNumber(winningNumbers));
    }

    public WinningNumbers(final List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.validateNumbers();
    }

    public static WinningNumbers create(final String numbers){
        return new WinningNumbers(createNumbers(numbers));
    }

    private static List<LottoNumber> convertIntToLottoNumber(int[] winningNumbers) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int winningNumber : winningNumbers) {
            numbers.add(new LottoNumber(winningNumber));
        }
        return numbers;
    }

    private static List<LottoNumber> createNumbers(String numbers) {
        String[] splitNumbers = splitNumbers(numbers);
        List<LottoNumber> lottoNumbers = new ArrayList<LottoNumber>();

        for (String number: splitNumbers) {
            int lottoNumber = parseInt(number);
            lottoNumbers.add(new LottoNumber(lottoNumber));
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
        duplicateNumber(winningNumbers);
    }

    private void validNumberCount(List<LottoNumber> numbers) {
        if(numbers.size() != WINNING_NUMBER_COUNT){
            throw new IllegalArgumentException("당첨 번호를 6개 입력하세요");
        }
    }

    private void duplicateNumber(List<LottoNumber> lottoNumbers) {
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
        for (LottoNumber lottoNumber : winningNumbers) {
            if(lotto.hasNumber(lottoNumber)) matchCount++;
        }
        return matchCount;
    }
}
