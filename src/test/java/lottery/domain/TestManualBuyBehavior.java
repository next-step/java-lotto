package lottery.domain;

import lottery.view.InputViewLotteryGame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TestManualBuyBehavior {
    @Test
    void create() {
        ManualBuyBehavior manualBuyBehavior = new ManualBuyBehavior() {
            @Override
            public List<LotteryNumber> getLotteryNumbers() {
                return Arrays.stream("1, 2, 3, 4, 5,6"
                        .replace(" ", "")
                        .split(","))
                        .map(Integer::parseInt)
                        .map(s -> lotteryAllNumbers.get(s - 1))
                        .collect(Collectors.toList());
            }
        };

        assertThat(manualBuyBehavior.getLotteryNumbers()).isEqualTo(new ArrayList<>(Arrays.asList(
                LotteryNumber.of(1),
                LotteryNumber.of(2),
                LotteryNumber.of(3),
                LotteryNumber.of(4),
                LotteryNumber.of(5),
                LotteryNumber.of(6)
        )));
    }
}
