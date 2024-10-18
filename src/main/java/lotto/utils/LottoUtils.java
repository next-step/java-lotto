package lotto.utils;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtils {

    private LottoUtils() {
    }

    public static List<Lotto> extractLottosFromStrings(String[] lottosStr) {
        return Arrays.stream(lottosStr)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

}
