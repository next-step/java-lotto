package lotto.services;

import lotto.strategy.NormalPickNumberStrategy;
import lotto.strategy.PickNumberStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PickNumberServiceTest {

    private static final PickNumberService pickNumberService = new PickNumberService();
    private static final PickNumberStrategy pickNumberStrategy = new NormalPickNumberStrategy();
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();
    private final static int RANGE_START = 1;
    private final static int RANGE_END = 45;
    private static final int NUMBER_COUNT = 6;

    @BeforeAll
    public static void setLottoNumbers() {
        for (int num = RANGE_START ; num <= RANGE_END ; num++ ) {
            LOTTO_NUMBERS.add(num);
        }
    }

    @Test
    @DisplayName("pickNumbers 메소드는 6개의 수를 획득한다.")
    void getNumber1() {
        assertThat(pickNumberService.pickNumbers(pickNumberStrategy).size()).isEqualTo(NUMBER_COUNT);
    }

    @Test
    @DisplayName("발급된 6개의 수는 1~45 사이의 값을 가진다.")
    void getNumber2() {
        pickNumberService.pickNumbers(pickNumberStrategy).forEach(num -> {
            assertThat(LOTTO_NUMBERS).contains(num);
        });
    }
}
