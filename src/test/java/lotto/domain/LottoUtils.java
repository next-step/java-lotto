package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtils {

    public static LottoNumbers lottoNumbers(String numbers) {
        List<Integer> inumbers = Arrays.asList(numbers.split(",")).stream()
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return new LottoNumbers(inumbers);
    }

    public static Lotto lotto(String numbers) {
        return new Lotto(numbers);
    }


}
