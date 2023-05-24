package autolotto.machine;

import autolotto.machine.lotto.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {
    public static List<LottoNumber> createLottoNumbers(List<Integer> integers) {
        return integers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
