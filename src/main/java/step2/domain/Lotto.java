package step2.domain;

import java.util.*;

public class Lotto {
    private LottoNumber lottoNumber;
    private List<Integer> numbers;
    private List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumber = new LottoNumber();
        numbers = new ArrayList<>();
        lottoNumbers = new ArrayList<>();
        List<Integer> generatedNumbers = generateLottoNumber();
        validateNumberLengthCheck(generatedNumbers);
        validateDuplicationCheck(generatedNumbers);
        this.numbers = generatedNumbers;
    }

    public List<Integer> generateLottoNumber() {
        lottoNumbers = lottoNumber.initializeLottoNumber();

        for (int i = 1; i <= LottoConstant.LOTTO_NUMBER_LENGTH; i++) {
            numbers.add(lottoNumbers.get(i));
        }
        Collections.sort(numbers);
        return numbers;
    }

    public void validateNumberLengthCheck(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(LottoConstant.VALID_LOTTO_NUMBER_LENGTH_MESSAGE);
        }
    }

    public void validateDuplicationCheck(List<Integer> numbers) {
        Set<Integer> checkList = new HashSet<>(numbers);
        if (numbers.size() != checkList.size()) {
            throw new IllegalArgumentException(LottoConstant.VALID_LOTTO_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
