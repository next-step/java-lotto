package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_LENGTH = 6;
    private static final String SPLIT_SEPARATOR = ",";
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumberEmpty(lottoNumbers);
        validateLottoNumberLength(lottoNumbers);
        validateSameNumber(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public int countMatchingLottoNumber(LottoNumbers lottoNumbers) {
        Set<LottoNumber> aggregateOfLottoNumber = new HashSet<>(this.lottoNumbers);
        aggregateOfLottoNumber.retainAll(lottoNumbers.lottoNumbers);

        return aggregateOfLottoNumber.size();
    }

    public boolean isMatchingLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public void validateLottoNumberLength(List<LottoNumber> lottoNumbers) {

        if (lottoNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또번호는 6개 여야합니다 :(");
        }
    }

    public void validateLottoNumberEmpty(List<LottoNumber> lottoNumbers) {

        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("로또번호가 입력되지 않았어요 :(");
        }

        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("로또번호가 입력되지 않았어요 :(");
        }
    }

    private void validateSameNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> removeDuplicateLottoNumber = new HashSet<>(lottoNumbers);

        if (removeDuplicateLottoNumber.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("중복된 로또번호가 존재해요 :(");
        }
    }

    public static LottoNumbers of(String requestNumber) {

        List<Integer> requestNumbers = toNumeric(requestNumber);
        List<LottoNumber> lottoNumbers = generateLottoNumber(requestNumbers);

        return new LottoNumbers(lottoNumbers);
    }

    private static List<LottoNumber> generateLottoNumber(List<Integer> requestNumberList) {

        return requestNumberList.stream()
                .map(LottoNumber::provideLottoNumber)
                .sorted(LottoNumber::compareTo)
                .collect(Collectors.toUnmodifiableList());
    }

    private static List<Integer> toNumeric(String requestNumber) {
        return Arrays.stream(requestNumber.split(SPLIT_SEPARATOR))
                .map(String::strip)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}

