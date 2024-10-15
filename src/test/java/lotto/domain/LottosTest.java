package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 리스트를 받으면 Lottos 객체를 생성한다.")
    void Lottos_객체_생성() {
        List<Lotto> lottos = List.of(new Lotto("1,2,3,4,5,6", ","), new Lotto("2,3,4,5,6,7", ","));
        assertThat(new Lottos(lottos).getSize()).isEqualTo(2);
    }
}
