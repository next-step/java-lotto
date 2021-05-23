package kr.insup.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("구입한 개수만큼 로또 게임 생성")
    @Test
    void 구입한_개수만큼_로또_게임_생성() {
        //given
        Lottos lottos = new Lottos(10);

        //when, then
        assertThat(lottos.size()).isEqualTo(10);
    }
}
