package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.model.Money;

class LottoGeneratorTest {

    @DisplayName("유저에게 입력받은 로또 번호가 주어졌을 때 수동 로또를 생성하는지 검증")
    @Test
    void manualLottoTest() {
        List<String> firstInput = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> secondInput = Arrays.asList("7", "8", "9", "10", "11", "12");
        List<List<String>> inputs = Arrays.asList(firstInput, secondInput);

        List<Lotto> manualLottos = LottoGenerator.generate(inputs);

        assertThat(inputs.size()).isEqualTo(manualLottos.size());
        assertThat(manualLottos.get(0)).isEqualTo(Lotto.from(firstInput));
        assertThat(manualLottos.get(1)).isEqualTo(Lotto.from(secondInput));
    }

    @DisplayName("Money가 인자로 주어졌을 때 해당 금액만큼 자동 로또를 생성하는지 검증")
    @Test
    void autoLottoTest() {
        assertThat(LottoGenerator.generate(new Money(14_000)).size()).isEqualTo(14);
    }
}
