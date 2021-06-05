package lotto.shop;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.lotto.Lotto;

import java.util.List;

public class NumberGeneratorTest {
    @Test
    @DisplayName("숫자 발생")
    void generate() {
        //given
        //when
        List<Integer> number = NumberGenerator.generate();
        //then
        assertThat(number.size()).isEqualTo(Lotto.MAX_COUNT);
    }
}
