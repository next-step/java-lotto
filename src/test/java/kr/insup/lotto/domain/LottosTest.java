package kr.insup.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @DisplayName("수동, 자동으로 구입하여 로또 게임 생성")
    @Test
    void 수동_자동으로_구입하여_로또_게임_생성() {
        //given
        List<String> lottoList = Arrays.asList(
                "1, 2, 3, 4, 5, 6",
                "2, 3, 4, 5, 6, 7",
                "4, 6, 7, 8, 10, 11"
        );

        Lottos lottos = new Lottos(4, lottoList);

        //when, then
        assertThat(lottos.size()).isEqualTo(7);
    }
}
