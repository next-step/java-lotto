package lotto.domain;

import lotto.exception.InvalidLottoNumberCountException;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int NORMAL_LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private static void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NORMAL_LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberCountException();
        }
    }

    public int size() {
        return lottoNumbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.toString())
                .collect(Collectors.joining(", ")) + "]";
    }
//
//    public int[] getMatchingRecords(LottoNumber winningLottoNumber) {
//        int[] matchingRecords = new int[4];
//
//        for (LottoNumber lottoNumber : lottoNumbers) {
//            long count = lottoNumber.countOfMatch(winningLottoNumber);
//            mappingRecordsToCountOfMatch(matchingRecords, count);
//        }
//        return matchingRecords;
//    }
//
//    private void mappingRecordsToCountOfMatch(int[] arr, long count) {
//        if (count == 3) {
//            arr[0]++;
//        } else if (count == 4) {
//            arr[1]++;
//        } else if (count == 5) {
//            arr[2]++;
//        } else if (count == 6) {
//            arr[3]++;
//        }
//    }
}
