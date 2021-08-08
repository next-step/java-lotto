package lotto;


import lotto.model.WinningNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class WinningNumberTest {

    private static final String TEST_NUMBER = "2,4,6,8,10,12";
    WinningNumber winningNumber;

    @BeforeEach
    void settingWinningNumber() {
        winningNumber = new WinningNumber(Arrays.stream(TEST_NUMBER.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    @Test
    void 당첨번호_포함인지_체크() {
        List<Integer> lottoNumber = Arrays.stream(TEST_NUMBER.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int number : lottoNumber) {
            assertThat(winningNumber.containsNumber(number))
                    .isTrue();
        }
    }


}
