package study.lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.Lotto;
import study.lotto.view.dto.ManualLottoParser;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @DisplayName("로또 수동 1건 생성 테스트")
    @Test
    void manual_로또_리스트_생성() {
        // given
        List<Set<Integer>> given = Collections.singletonList(
                IntStream.rangeClosed(1, 6)
                        .boxed()
                        .collect(toSet()));
        ManualLottoParser manualLottoParser = ManualLottoParser.of(given);
        // when
        List<Lotto> manualAndAuto = LottoFactory.createManualAndAuto(0, manualLottoParser);
        // then
        assertThat(manualAndAuto).isEqualTo(LottoFactory.createManualAndAuto(0, manualLottoParser));
    }
}
