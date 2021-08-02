package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
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
