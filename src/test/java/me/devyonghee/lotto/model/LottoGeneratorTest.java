package me.devyonghee.lotto.model;

import me.devyonghee.common.StringsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 생성기")
class LottoGeneratorTest {

    @Test
    @DisplayName("문자들 제공자들로 정상 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> LottoGenerator.from(Collections.singletonList(() -> Collections.singletonList("1"))));
    }

    @Test
    @DisplayName("문자들 제공자들은 필수")
    void instance_nullProviders_thrownNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> LottoGenerator.from(null));
    }

    @Test
    @DisplayName("주어진 문자열들로 수동 로또 생성")
    void manualLottos() {
        //given
        StringsProvider oneToSixStrings = () -> Arrays.asList("1", "2", "3", "4", "5", "6");
        //when, then
        assertThat(LottoGenerator.from(Collections.singletonList(oneToSixStrings)).manualLottos())
                .isEqualTo(Lottos.from(Collections.singletonList(Lotto.auto(LottoNumbersTest.ONE_TO_SIX_NUMBERS))));
    }

    @Test
    @DisplayName("주어진 숫자만큼 자동 로또 생성")
    void autoLottos() {
        //given
        int count = 1;
        //when, then
        assertThat(LottoGenerator.from(Collections.emptyList()).autoLottos(count))
                .extracting(Lottos::size)
                .isEqualTo(count);
    }
}
