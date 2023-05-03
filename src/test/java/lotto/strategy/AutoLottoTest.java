package lotto.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class AutoLottoTest {

    @Test
    @DisplayName("자동 로또 생성 테스트")
    void test() {
        // given
        AutoLotto autoLotto = new AutoLotto();

        // when
        final List<Integer> lottoNumberGenerate = autoLotto.generateNumbers();

        // then
        assertThat(lottoNumberGenerate).hasSize(6);
    }
}