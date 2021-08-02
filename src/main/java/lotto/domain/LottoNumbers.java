package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
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

    //    public String value() {
//        return "[" + lottoNumbers.stream()
//                .map(lottoNumber -> lottoNumber.value())
//                .collect(Collectors.joining(", ")) + "]";
//    }
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
