package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningLottoTest {

    @Test
    @DisplayName("우승 로또 생성 테스트 - 개수 확인")
    void create_winningLotto_size_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            //given
            LottoBalls lottoBalls = LottoBalls.of(1, 2, 3, 4, 5);
            LottoBall bonusBall = LottoBall.valueOf(45);

            //when & then
            WinningLotto winningLotto = new WinningLotto(lottoBalls, bonusBall);
        }).withMessage("로또 숫자 개수가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("우승 로또 생성 테스트 - 보너스 볼 중복 확인")
    void create_winningLotto_duplication_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            //given
            LottoBalls lottoBalls = LottoBalls.of(1, 2, 3, 4, 5, 6);
            LottoBall bonusBall = LottoBall.valueOf(1);

            //when & then
            WinningLotto winningLotto = new WinningLotto(lottoBalls, bonusBall);
        }).withMessage("보너스볼은 중복될 수 없습니다.");
    }

}
