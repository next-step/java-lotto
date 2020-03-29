package study.lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRule {
    private static final int LOTTO_NUMBER_TOTAL = 6;

    public static boolean isComplianceNumberRule(int[] lottoNumbers) {
        if (Objects.isNull(lottoNumbers) ||
                lottoNumbers.length != LOTTO_NUMBER_TOTAL) {
            return false;
        }

        Set<Integer> uniqLottoNumbers = IntStream.of(lottoNumbers)
                .boxed()
                .collect(Collectors.toSet());
        if (uniqLottoNumbers.size() != LOTTO_NUMBER_TOTAL) {
            return false;
        }

        return true;
    }


}
