package lotto.utils;

import lotto.domain.LottoBall;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoHelper {
    public static List<LottoBall> convertToBalls(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(number -> new LottoBall(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }
}
