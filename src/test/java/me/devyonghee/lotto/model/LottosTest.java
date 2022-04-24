package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또들")
class LottosTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Lottos.from(Collections.singletonList(
                Lotto.from(LottoNumbers.from(IntStream.rangeClosed(1, 6).mapToObj(LottoNumber::from).collect(Collectors.toList()))
                ))));
    }

    @Test
    @DisplayName("로또들은 필수")
    void instance_null_thrownNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> Lottos.from(null));
    }

    @Test
    @DisplayName("점수")
    void score() {
        //given
        Lotto lotto = Lotto.from(LottoNumbers.from(
                IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::from)
                        .collect(Collectors.toList())
        ));
        //when
        Score score = Lottos.from(Collections.singletonList(lotto)).score(lotto);
        //then
        assertThat(score.count(Rank.FIRST)).isOne();
    }
}
