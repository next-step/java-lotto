package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLotteryGame extends AbstractLotteryGame {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final List<LotteryNumber> LOTTO_LIST = new ArrayList<>() {{
        for (int i = START_NUMBER; i < END_NUMBER; i++) {
            add(LotteryNumber.of(i));
        }
    }};

    public AutoLotteryGame() {
        create();
    }

    void create() {
        Collections.shuffle(LOTTO_LIST);
        List<LotteryNumber> subList = new ArrayList<>(LOTTO_LIST.subList(0, 6));
        subList = subList.stream().map(LotteryNumber::getNumber).sorted().map(LotteryNumber::of).collect(Collectors.toList());
        lotteries = Collections.unmodifiableList(subList);
    }
}
