package step2.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.lotto.Lotto;
import step2.exception.LottoShuffleNullPointerException;
import step2.strategy.LottoShuffleStrategy;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGenerateMachineTest {

    @DisplayName("LottoGenerateMachine 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // given
        LottoShuffleStrategy strategy = lottoNumbers -> { };

        // when
        LottoGenerateMachine lottoGenerateMachine = LottoGenerateMachine.of(strategy);

        // then
        assertThat(lottoGenerateMachine).isNotNull();
    }

    @DisplayName("LottoGenerateMachine 인스턴스에 null 주입시 예외처리 테스트")
    @Test
    void 검증() {
        // when
        assertThatThrownBy(() -> LottoGenerateMachine.of(null))
                .isInstanceOf(LottoShuffleNullPointerException.class)
                .hasMessageContaining("셔플 전략이 null 입니다.");
    }

    @DisplayName("LottoGenerateMachine 인스턴스에 일반 셔플 주입시 반환 값 테스트")
    @Test
    void 반환값_일반셔플() {
        // given
        LottoShuffleStrategy strategy = Collections::sort;
        Lotto expected = Lotto.of("1, 2, 3, 4, 5, 6");

        // when
        LottoGenerateMachine lottoGenerateMachine = LottoGenerateMachine.of(strategy);
        List<Lotto> data = lottoGenerateMachine.generateLottos(LottoGenerateCount.of(1000));
        Lotto actual = data.get(0);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("LottoGenerateMachine 인스턴스에 역순 셔플 주입시 반환 값 테스트")
    @Test
    void 반환값_역순셔플() {
        // given
        LottoShuffleStrategy strategy = Collections::reverse;
        Lotto expected = Lotto.of("45, 44, 43, 42, 41, 40");

        // when
        LottoGenerateMachine lottoGenerateMachine = LottoGenerateMachine.of(strategy);
        List<Lotto> data = lottoGenerateMachine.generateLottos(LottoGenerateCount.of(1000));
        Lotto actual = data.get(0);

        // then
        assertThat(actual).isEqualTo(expected);
    }


}