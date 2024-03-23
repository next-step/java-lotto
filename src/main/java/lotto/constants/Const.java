package lotto.constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Const {

    public static final String GET_TRY_NO = "구입금액을 입력해 주세요.";
    public static final List<Integer> NUMBER_LIST = IntStream.rangeClosed(1, 45)
            .boxed().collect(Collectors.toList());
}
