package lotto.domain;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class ProviderLottoNumbers {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final List<Integer> numbers = new ArrayList<>();
    private static final int CAPACITY = 6;

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).forEach(numbers::add);
    }

    private ProviderLottoNumbers() {
    }

    public static List<Integer> findAllLottoNumbers() {
        return numbers;
    }

    public static Lotto getLottoNumbers(LottoMachine lottoMachine) {
        return lottoMachine.createLotto(CAPACITY);
    }
    public static void isValidLottoNumber(Set<Integer> lottoNumbers) {
        if(lottoNumbers.size() != CAPACITY || isValidRange(lottoNumbers)){
            throw new NotValidLottoNumberException(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean isValidRange(Set<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(number -> number < ProviderLottoNumbers.MIN_LOTTO_NUMBER
                        || number > ProviderLottoNumbers.MAX_LOTTO_NUMBER);
    }

    public static void isValidRange(int lottoNumber) {
        if(lottoNumber < ProviderLottoNumbers.MIN_LOTTO_NUMBER || lottoNumber > ProviderLottoNumbers.MAX_LOTTO_NUMBER) {
            throw new NotValidLottoNumberException(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
        }
    }
}
