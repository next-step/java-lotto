package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {

    static Stream<Arguments> lottoSource() {
        return Stream.of(arguments(
                new Lotto(LottoBalls.createManualLottoBalls(1, 2, 3, 4, 5, 6)),
                WinningLotto.of(1, 2, 3, 4, 5, 6, 7)
        ));
    }

    @Test
    @DisplayName("자동 로또 생성 테스트 - 개수 확인")
    void create_auto_lotto_size_test() {
        Lotto lotto = new Lotto();

        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("수동 로또 생성 테스트")
    void create_manual_lotto_test() {
        List<Integer> list = IntStream.range(1, 7).boxed().collect(Collectors.toList());
        Lotto lotto = Lotto.createManualLotto(list);

        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("수동 로또 생성 테스트 - 개수 확인")
    void create_manual_lotto_size_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            //given
            LottoBalls lottoBalls = LottoBalls.createManualLottoBalls(1, 2, 3, 43, 44);

            //when & then
            Lotto lotto = new Lotto(lottoBalls);
        }).withMessage("로또 숫자 개수가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("로또 생성 테스트 - 중복 확인")
    void create_lotto_duplication_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            //given
            LottoBalls lottoBalls = LottoBalls.createManualLottoBalls(1, 1, 3, 43, 44, 45);

            //when & then
            Lotto lotto = new Lotto(lottoBalls);
        }).withMessage("로또에 중복된 값이 있습니다.");
    }

    @ParameterizedTest
    @DisplayName("보너스볼 일치 여부 테스트")
    @MethodSource("lottoSource")
    void check_bonus_ball(Lotto lotto, WinningLotto winningLotto) {

        boolean checkBonus = lotto.containsBonus(winningLotto);
        assertThat(checkBonus).isTrue();
    }

    @ParameterizedTest
    @DisplayName("두 로또 번호를 비교해 맞은 개수 반환 테스트")
    @MethodSource("lottoSource")
    void count_match_numbers(Lotto lotto, WinningLotto winningLotto) {

        int winningCounts = lotto.countMatch(winningLotto);
        assertThat(winningCounts).isEqualTo(5);
    }
}
