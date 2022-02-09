package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallsTest {

    @DisplayName("로또 번호는 1부터 45까지의 범위이다.")
    @Test
    void When_로또_공_생성_Then_범위는_1부터_45() {
        // when
        final List<Integer> balls = LottoBalls.get().stream().
                map(LottoNumber::getValue)
                .collect(Collectors.toList());

        // then
        assertThat(balls.size()).isEqualTo(45);
        for (int i = 1; i <= 45; i++) {
            assertThat(balls).contains(i);
        }
    }

    @DisplayName("로또 번호 리스트가 섞인다.")
    @Test
    void When_로또_번호_리스트_섞기_Then_섞기_전과_요소의_순서가_다름() {
        // given
        final List<LottoNumber> before = new ArrayList<>(LottoBalls.get());

        // when
        LottoBalls.shuffle();

        // then
        assertThat(LottoBalls.get()).isNotEqualTo(before);
    }


    @DisplayName("임의의 6개의 로또번호가 생성된다.")
    @Test
    void When_로또번호_생성_Then_로또볼_에서_6개를_뽑는다() {
        // when
        Set<LottoNumber> lottoNumbers = LottoBalls.createLottoNumber();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @DisplayName("생성된 로또 번호는 오름차순으로 정렬 된다.")
    @Test
    void When_로또번호_생성_Then_오른_차순_정렬됨() {
        // when
        List<Integer> lottoNumbers = LottoBalls.createLottoNumber().stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());

        // then
        int prev= 0;
        for(int number : lottoNumbers){
            assertTrue(number > prev);
            prev = number;
        }
    }
}
