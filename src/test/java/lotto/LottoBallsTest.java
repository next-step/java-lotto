package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallsTest {

    @DisplayName("로또 번호는 1부터 45까지의 범위이다.")
    @Test
    void When_로또_공_생성_Then_범위는_1부터_45() {

        // when
        final List<String> balls = LottoBalls.get();

        // then
        assertThat(balls.size()).isEqualTo(45);
        for (int i = 1; i <= 45; i++) {
            assertThat(balls).contains(String.valueOf(i));
        }
    }

    @DisplayName("로또 번호 리스트가 섞인다.")
    @Test
    void When_로또_번호_리스트_섞기_Then_섞기_전과_요소의_순서가_다름() {
        // given
        final ArrayList<String> before = new ArrayList<>(LottoBalls.get());

        // when
        LottoBalls.shuffle();

        // then
        assertThat(LottoBalls.get()).isNotEqualTo(before);
    }


    @DisplayName("임의의 6개의 로또번호가 생성된다.")
    @Test
    void When_로또번호_생성_Then_로또볼_에서_6개를_뽑는다() {
        // when
        List<String> lottoNumber = LottoBalls.createLottoNumber();

        // then
        assertThat(lottoNumber.size()).isEqualTo(6);
    }
}
