package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtils {

    public static Lotto lotto(String numbers) {
        List<Integer> inumbers = Arrays.asList(numbers.split(",")).stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return new Lotto(new LottoNumber(inumbers));
    }

}
