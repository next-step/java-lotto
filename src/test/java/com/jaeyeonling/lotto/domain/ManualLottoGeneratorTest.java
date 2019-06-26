package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoGeneratorTest {

    @DisplayName("로또 수동 생성 ")
    @Test
    void should_return_manualLotto_when_generate() {
        final Lotto lotto = new FixtureLotto();
        final LottoGenerator manualLottoGenerator = new ManualLottoGenerator(List.of(lotto));

        final Lotto expect = manualLottoGenerator.generate();

        assertThat(lotto).isEqualTo(expect);
    }
}
