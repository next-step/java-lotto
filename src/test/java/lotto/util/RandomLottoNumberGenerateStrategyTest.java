package lotto.util;

import lotto.vo.LottoRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoNumberGenerateStrategyTest {

    private NumberGenerateStrategy numberGenerateStrategy;

    @DisplayName("LottoRule 의 시작 값과 종료 값의 사이에서 카운트 만큼의 숫자만 랜덤으로 나온다.")
    @Test
    void generateTest() {

        numberGenerateStrategy = new RandomLottoNumberGenerateStrategy();

        List<Integer> generate = numberGenerateStrategy.generate();

        assertThat(generate.size()).isEqualTo(LottoRule.LOTTO_COUNT.getValue());
        System.out.println("generate = " + generate);
    }
}