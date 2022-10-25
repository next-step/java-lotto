package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoPaper {
    private final List<LottoNumber> lottoNumbers;

    public LottoPaper(List<Integer> lottoNumbersInput) {
        List<LottoNumber> lottoNumbers = integersToLottoNumbers(lottoNumbersInput);
        duplicateCheck(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private List<LottoNumber> integersToLottoNumbers(List<Integer> lottoNumbersInput) {
        validateLottoNumbers(lottoNumbersInput);
        return lottoNumbersInput.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateLottoNumbers(List<Integer> lottoNumbersInput) {
        List<Integer> invalidLottoNumbersInput = getInvalidLottoNumbersInput(lottoNumbersInput);
        if (invalidLottoNumbersInput.size() == 0) {
            return;
        }
        String invalidInput = convertStringAndJoin(invalidLottoNumbersInput);
        throw new IllegalArgumentException("1~45 사이의 정수만 로또번호가 될 수 있습니다. 입력값 중 허용되지 않는값: " + invalidInput);
    }

    private String convertStringAndJoin(List<Integer> integers) {
        return integers.stream()
                .map(integer -> Integer.toString(integer))
                .collect(Collectors.joining(","));
    }

    private List<Integer> getInvalidLottoNumbersInput(List<Integer> lottoNumbersInput) {
        return lottoNumbersInput.stream()
                .filter(integer -> {
                    try {
                        LottoNumber.validateLottoRange(integer);
                        return false;
                    } catch (Exception exception) {
                        return true;
                    }
                })
                .collect(Collectors.toList());
    }


    private void duplicateCheck(List<LottoNumber> lottoNumbers) {
        Map<Integer, Long> countPerNumber = getCountPerNumber(lottoNumbers);
        Map<Integer, Long> duplicateLottoNumbers = getDuplicateArgs(countPerNumber);
        if (duplicateLottoNumbers.size() > 0) {
            throw new IllegalArgumentException("같은 숫자를 2번이상 입력할 수 없습니다. " + getDuplicateExceptionMessage(duplicateLottoNumbers));
        }
    }

    private Map<Integer, Long> getCountPerNumber(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .collect(Collectors.groupingBy(
                        LottoNumber::getLottoNumber,
                        Collectors.counting()
                ));
    }

    private Map<Integer, Long> getDuplicateArgs(Map<Integer, Long> countPerNumber) {
        return countPerNumber.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private String getDuplicateExceptionMessage(Map<Integer, Long> duplicateLottoNumbers) {
        return duplicateLottoNumbers.entrySet().stream()
                .map(entry -> "입력한 숫자: " + entry.getKey() + ", 중복 입력한 횟수: " + entry.getValue())
                .collect(Collectors.joining("|"));
    }


    public boolean isInclude(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }


    public int compareMatch(LottoPaper targetLottoPaper) {
        return (int) this.lottoNumbers.stream()
                .filter(targetLottoPaper::isInclude)
                .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
