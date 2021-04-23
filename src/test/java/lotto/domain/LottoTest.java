package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트 - 개수 확인")
    void create_lotto_size_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            //given
            LottoBalls lottoBalls = LottoBalls.of(1, 2, 3, 43, 44);

            //when & then
            Lotto lotto = new Lotto(lottoBalls);
        }).withMessage("로또 숫자 개수가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("로또 생성 테스트 - 중복 확인")
    void create_lotto_duplication_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            //given
            LottoBalls lottoBalls = LottoBalls.of(1, 1, 3, 43, 44, 45);

            //when & then
            Lotto lotto = new Lotto(lottoBalls);
        }).withMessage("당첨 로또에 중복된 값이 있습니다.");
    }

    @Test
    @DisplayName("두 로또 번호를 비교해 맞은 개수 반환 테스트")
    void count_match_numbers() {
        //given
        LottoBalls lottoBalls = LottoBalls.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto lotto = new Lotto(lottoBalls);
        int winningCounts = lotto.countMatch(WinningLotto.of(1, 2, 3, 4, 5, 6, 7));

        //then
        assertThat(winningCounts).isEqualTo(6);
    }
}
