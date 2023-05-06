package lottoauto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Constant {

    public static final int ONE_LOTTO_AMOUNT = 1000;

    public static final List<Integer> LOTTO_NUMBER_RANGE = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    public static class Input {

        public static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
        public static final String LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    }
}
