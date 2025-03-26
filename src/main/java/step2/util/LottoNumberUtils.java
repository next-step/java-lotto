package step2.util;

import step2.domain.LottoNum;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberUtils {
    public static Set<LottoNum> of(Integer... nums) {
        return Arrays.stream(nums)
                .map(LottoNum::new)
                .collect(Collectors.toSet());
    }

}
