package lotto.domain;

import lotto.utils.LottoInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private List lastWeekNumbers = Arrays.asList(10, 15, 20, 30, 40, 45);


    @DisplayName("5개 일치하는 로또 게임 한개 존재")
    @Test
    void makeResultStaticsOneTimes() {
        Lottos lottos = new Lottos(1, new LottoInput(Arrays.asList(10, 20, 25, 30, 40, 45)));
        Map expectedResult = new HashMap();
        expectedResult.put(3, 0);
        expectedResult.put(4, 0);
        expectedResult.put(5, 1);
        expectedResult.put(6, 0);

        Map result = lottos.makeResultStatics(lastWeekNumbers);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("5개 일치하는 로또 게임 두개 존재")
    @Test
    void makeResultStaticsWithTwoTimes() {

        Lottos lottos = new Lottos(2, new LottoInput(Arrays.asList(10, 20, 25, 30, 40, 45)));

        Map expectedResult = new HashMap();
        expectedResult.put(3, 0);
        expectedResult.put(4, 0);
        expectedResult.put(5, 2);
        expectedResult.put(6, 0);

        Map result = lottos.makeResultStatics(lastWeekNumbers);
        assertThat(result).isEqualTo(expectedResult);
    }
}