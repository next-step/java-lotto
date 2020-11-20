package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtils {

    public static LottoNumber lottoNumber(String numbers) {
        List<Integer> inumbers = Arrays.asList(numbers.split(",")).stream()
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return new LottoNumber(inumbers);
    }

    public static Lotto lotto(String numbers) {
        return new Lotto(lottoNumber(numbers));
    }


}
