package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMockFactory {
    private static int fourTeenLottoNumbers[][] = {
            {8, 21, 23, 41, 42, 43},
            {3, 5, 11, 16, 32, 38},
            {7, 11, 16, 35, 36, 44},
            {1, 8, 11, 31, 41, 42},
            {13, 14, 16, 38, 42, 45},
            {7, 11, 30, 40, 42, 43},
            {2, 13, 22, 32, 38, 45},
            {23, 25, 33, 36, 39, 41},
            {1, 3, 5, 14, 22, 45},
            {5, 9, 38, 41, 43, 44},
            {2, 8, 9, 18, 19, 21},
            {13, 14, 18, 21, 23, 35},
            {17, 21, 29, 37, 42, 45},
            {3, 8, 27, 30, 35, 44}
    };
    
    public static List<Lotto> createFourTeenLotto() {
        List<LottoNumber> lottoNumbers = Arrays.stream(fourTeenLottoNumbers)
                .flatMapToInt(Arrays::stream)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());

        List<Lotto> lottos = new ArrayList<>();

        final int partitionSize = 6;
        int i = 0;
        while (i < lottoNumbers.size()) {
            List<LottoNumber> partition = lottoNumbers.subList(i, i + partitionSize);
            i += partitionSize;
            lottos.add(Lotto.of(partition));
        }
        return lottos;
    }
}
