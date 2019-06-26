package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
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

    @DisplayName("로또 여러개 수동 생성 ")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            2,
            23,
            50,
            1000
    })
    void should_return_manualLottos_when_generate(final int count) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new FixtureLotto());
        }

        final LottoGenerator manualLottoGenerator = new ManualLottoGenerator(lottos);

        final List<Lotto> expect = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            expect.add(manualLottoGenerator.generate());
        }

        assertThat(lottos).hasSize(count);
        assertThat(lottos).containsAll(expect);
    }
}
