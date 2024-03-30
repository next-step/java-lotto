package lotto.constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Const {

    public static final String RESULT = "당첨 통계";


    public static final int LOTTO_COST = 1000;

    public static final List<Integer> NUMBER_LIST = IntStream.rangeClosed(1, 45)
            .boxed().collect(Collectors.toList());
}
