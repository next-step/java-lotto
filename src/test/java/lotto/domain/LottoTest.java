package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LottoTest {

    private List lastWeekNumbers = Arrays.asList(10, 15, 20, 30, 40, 45);

    @Test
    void makeResultStaticsOneTimes() {
        Lotto lotto = new Lotto(Arrays.asList(10, 20, 25, 30, 40, 45));
        System.out.println(lotto.toString());
    }
}