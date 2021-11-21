package edu.nextstep.camp.lotto.domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    public void generate() {
        final List<LottoNumber> lottoNumberList = List.of(LottoNumber.of(1),LottoNumber.of(2),LottoNumber.of(3),
                LottoNumber.of(4),LottoNumber.of(5),LottoNumber.of(6));
        assertThat(new FixedLottoGenerator().generate().collect()).hasSameElementsAs(lottoNumberList);
    }

    @Test
    public void autoGenerate() {
        assertThat(AutoLottoGenerator.getInstance().generate().collect()).hasSize(6);
        assertThat(AutoLottoGenerator.getInstance().generate().collect()).hasOnlyElementsOfType(LottoNumber.class);
    }

    @ParameterizedTest(name = "check generated amount: {arguments}")
    @ValueSource(ints = {1, 10})
    public void checkGeneratedAmount(int amount) {
        assertThat(AutoLottoGenerator.getInstance().generate(amount).amount()).isEqualTo(amount);
    }
}
