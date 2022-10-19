package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static step2.domain.Util.exceptionWrapper;

public class LottoNumber {
    private final List<LottoNumberElement> lottoNumber;

    public LottoNumber(List<Integer> integerLottoNumber) {
        List<LottoNumberElement> lottoNumber = integersToLottoNumber(integerLottoNumber);
        duplicateCheck(lottoNumber);
        this.lottoNumber = Collections.unmodifiableList(lottoNumber);
    }

    private void duplicateCheck(List<LottoNumberElement> lottoNumber) {
        Map<Integer, Long> countPerNumber = getCountPerNumber(lottoNumber);
        Map<Integer, Long> duplicateNumbers = getDuplicateArgs(countPerNumber);
        if (duplicateNumbers.size() > 0) {
            throw new IllegalArgumentException("같은 숫자를 2번이상 입력할 수 없습니다. " + getDuplicateExceptionMessage(duplicateNumbers));
        }
    }

    private Map<Integer, Long> getCountPerNumber(List<LottoNumberElement> lottoNumber) {
        return lottoNumber.stream()
                .collect(Collectors.groupingBy(
                        LottoNumberElement::getLottoNumberElement,
                        Collectors.counting()
                ));
    }

    private Map<Integer, Long> getDuplicateArgs(Map<Integer, Long> countPerNumber) {
        return countPerNumber.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private String getDuplicateExceptionMessage(Map<Integer, Long> duplicateNumbers) {
        return duplicateNumbers.entrySet().stream()
                .map(entry -> "입력한 숫자: " + entry.getKey() + ", 중복 입력한 횟수: " + entry.getValue())
                .collect(Collectors.joining("|"));
    }

    private List<LottoNumberElement> integersToLottoNumber(List<Integer> integerLottoNumber) {
        List<LottoNumberElement> lottoNumber = integerLottoNumber.stream()
                .map(exceptionWrapper(LottoNumberElement::new))
                .collect(Collectors.toList());
        if (lottoNumber.contains(null)) {
            throw new IllegalArgumentException();
        }
        return lottoNumber;
//        return integerLottoNumber.stream().map(LottoNumberElement::new).collect(Collectors.toList());
    }

    public boolean isInclude(LottoNumberElement lottoNumberElement) {
        return lottoNumber.contains(lottoNumberElement);
    }


    public int compareMatch(LottoNumber targetLottoNumber) {
        return (int) this.lottoNumber.stream()
                .filter(targetLottoNumber::isInclude)
                .count();
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
