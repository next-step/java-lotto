package lotto.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 특정회차 테스트")
class RoundTest {

    @Test
    @DisplayName("로또 당첨번호 자동생성")
    public void autoTest() {
        Round round = new Round(1, SixBall.get());

        System.out.println(round);
        assertThat(round).isNotNull();
    }

    @Test
    @DisplayName("로또 당첨번호 직접입력")
    public void fixTest() {
        Round round = new Round(1, SixBall.get(1, 2, 3, 4, 5, 6));

        System.out.println(round);
        assertThat(round).isNotNull();
    }
}