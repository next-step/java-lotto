package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    private static final String IS_NOT_LOTTO_SIZE = "번호가 6개가 아닙니다.";
    private static final String INPUT_IS_NOT_NUMBER = "입력된 값이 숫자가 아닙니다.";
    private static final String IS_NOT_LOTTO_NUMBER = "로또번호가 1~45가 아닙니다.";
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final String IS_DUPLICATE_NUMBER = "중복된 번호가 있습니다.";

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoNumbers = makeSortLotto(lottoNumbers);
    }

    private void validateLotto(List<Integer> lottoNumbers) {
        validateLottoSetSize(lottoNumbers);
        valdiateDuplicate(lottoNumbers);

    }

    private void validateLottoSetSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_SIZE);
        }
    }

    private void valdiateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(IS_DUPLICATE_NUMBER);
        }
    }

    private List<Integer> makeSortLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        validateLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(num -> num < LOTTO_MIN_NUM || num > LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_NUMBER);
        }
    }

    public static LottoNumbers stringLottoNumbers(String[] inputNumbers) {
        return new LottoNumbers(splitInput(inputNumbers));
    }

    private static List<Integer> splitInput(String[] inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            numbers.add(convertStringToInt(number));
        }
        return numbers;
    }

    private static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean isNumberContain(int number) {
        return lottoNumbers.contains(number);
    }

    public int getMatchCount(List<Integer> winningLottoNumbers) {
        return (int) winningLottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public void validateDuplicate(int number) {
        if (lottoNumbers.contains(number)) {
            throw new IllegalArgumentException(IS_DUPLICATE_NUMBER);
        }
    }
}
