package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또들")
class LottosTest {

    @Test
    @DisplayName("하나의 로또로 로또들 정상 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Lottos.from(Collections.singletonList(LottoTest.ONE_TO_SIX_LOTTO)));
    }

    @Test
    @DisplayName("로또들은 필수")
    void instance_null_thrownNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> Lottos.from(null));
    }

    @Test
    @DisplayName("주어진 로또들 그대로 반환")
    void list() {
        //given
        List<Lotto> lottos = Collections.singletonList(LottoTest.ONE_TO_SIX_LOTTO);
        //when, then
        assertThat(Lottos.from(lottos).list()).isEqualTo(lottos);
    }

    @Test
    @DisplayName("점수")
    void score() {
        //given, when
        Score score = Lottos.from(Collections.singletonList(LottoTest.ONE_TO_SIX_LOTTO))
                .score(LottoTest.ONE_TO_SIX_LOTTO);
        //then
        assertThat(score.count(Rank.FIRST)).isOne();
    }
}
