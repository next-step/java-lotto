package edu.nextstep.camp.lotto.domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    public void generate() {
        assertThat(FixedLottoGenerator.getInstance().generate().collect()).hasSameElementsAs(List.of("1", "2", "3", "4", "5", "6"));
    }

    @Test
    public void autoGenerate() {
        assertThat(AutoLottoGenerator.getInstance().generate().collect()).hasSize(6);
    }

    @ParameterizedTest(name = "check generated amount: {arguments}")
    @ValueSource(ints = {1, 10})
    public void checkGeneratedAmount(int amount) {
        assertThat(AutoLottoGenerator.getInstance().generate(amount).amount()).isEqualTo(amount);
    }
}
