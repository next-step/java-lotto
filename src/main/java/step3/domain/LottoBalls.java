package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBalls {

    private static List<Integer> lottoBalls = IntStream
            .rangeClosed(LottoNumber.MINIMUM_LOTTO_NUMBER, LottoNumber.MAXIMUM_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static List<Integer> getLottoBalls() {
        return lottoBalls;
    }
}
