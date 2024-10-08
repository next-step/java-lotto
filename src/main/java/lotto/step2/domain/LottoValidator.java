package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoValidator {
    private static final String LOTTO_NUMBERS_SEPARATOR = ", ";
    private static final int LOTTO_COUNT_LIMIT = 6;
    private static final int LIMIT_LOTTO_NUMBER = 45;

    private LottoValidator(){}

    public static void validate(String numbers){
        List<Integer> lottoNumbers = createNumbers(numbers);
        validateNumbers(lottoNumbers);
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

    private static int parseInt(String number) {
        int lottoNumber;
        try{
            lottoNumber = Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력 가능합니다");
        }
        return lottoNumber;
    }

    private static void validateNumbers(List<Integer> lottoNumbers) {
        validNumberCount(lottoNumbers);
        validNumberRange(lottoNumbers);
        duplicateNumber(lottoNumbers);
    }

    public static void validate(List<Integer> numbers){
        validateNumbers(numbers);
    }

    private static String[] splitNumbers(String numbers) {
        return numbers.split(LOTTO_NUMBERS_SEPARATOR);
    }

    private static void duplicateNumber(List<Integer> lottoNumbers) {
        long count = lottoNumbers.stream()
                            .distinct()
                            .count();

        if(count < LOTTO_COUNT_LIMIT){
            throw new IllegalArgumentException("로또번호가 중복됐습니다");
        }
    }

    private static void validNumberCount(List<Integer> numbers) {
        if(numbers.size() != LOTTO_COUNT_LIMIT){
            throw new IllegalArgumentException("로또 번호를 6개 입력하세요");
        }
    }

    private static void validNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if(isNonValidNumber(number)){
                throw new IllegalArgumentException("1-45범위 내의 로또 번호를 입력하세요");
            }
        }
    }

    private static boolean isNonValidNumber(int lottoNumber) {
        return lottoNumber <= 0 || lottoNumber > LIMIT_LOTTO_NUMBER;
    }
}
