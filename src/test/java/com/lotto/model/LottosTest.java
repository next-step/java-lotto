package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("로또 갯수 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {10, 5, 4})
    public void numberOfLotto(int number) {
        //when
        Lottos lottos = new Lottos(number);

        //then
        assertThat(lottos.lottoStream().count())
                .isEqualTo(number);
    }
}
