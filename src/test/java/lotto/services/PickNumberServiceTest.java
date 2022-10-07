package lotto.services;

import lotto.strategy.NormalPickNumberStrategy;
import lotto.strategy.PickNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PickNumberServiceTest {

    private static final PickNumberService pickNumberService = new PickNumberService();
    private static final PickNumberStrategy pickNumberStrategy = new NormalPickNumberStrategy();
    private static final List<Integer> LOTTO_NUMBERS = List.of(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45
    );
    private static final int NUMBER_COUNT = 6;

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
