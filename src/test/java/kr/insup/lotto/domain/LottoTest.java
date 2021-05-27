package kr.insup.lotto.domain;

import kr.insup.lotto.utils.LottoNumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("당첨 번호 1등 테스트")
    @Test
    void 당첨_번호_1등_테스트() {
        //given
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningNumbers = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        //when, then
        assertThat(lotto.matchWinningNumber(winningNumbers)).isEqualTo(LottoPrize.First);
    }

    @DisplayName("당첨 번호 2등 테스트")
    @Test
    void 당첨_번호_2등_테스트() {
        //given
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningLotto winningNumbers = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        //when, then
        assertThat(lotto.matchWinningNumber(winningNumbers)).isEqualTo(LottoPrize.Second);
    }

    @DisplayName("당첨 번호 3등 테스트")
    @Test
    void 당첨_번호_3등_테스트() {
        //given
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningLotto winningNumbers = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10);

        //when, then
        assertThat(lotto.matchWinningNumber(winningNumbers)).isEqualTo(LottoPrize.Third);
    }

    @DisplayName("당첨 번호 4등 테스트")
    @Test
    void 당첨_번호_4등_테스트() {
        //given
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningNumbers = new WinningLotto(Arrays.asList(1, 2, 3, 4, 7, 8), 6);

        //when, then
        assertThat(lotto.matchWinningNumber(winningNumbers)).isEqualTo(LottoPrize.Fourth);
    }

    @DisplayName("당첨 번호 5등 테스트")
    @Test
    void 당첨_번호_5등_테스트() {
        //given
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningNumbers = new WinningLotto(Arrays.asList(1, 2, 3, 7, 8, 9), 13);

        //when, then
        assertThat(lotto.matchWinningNumber(winningNumbers)).isEqualTo(LottoPrize.Fifth);
    }

    @DisplayName("아무것도 당첨 안됨 테스트")
    @Test
    void 아무것도_당첨_안됨_테스트() {
        //given
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningNumbers = new WinningLotto(Arrays.asList(1, 2, 7, 8, 9, 10), 3);

        //when, then
        assertThat(lotto.matchWinningNumber(winningNumbers)).isEqualTo(LottoPrize.None);
    }

    @DisplayName("당첨번호 입력 시 validation test")
    @ParameterizedTest
    @ValueSource(strings = {
            "2, 10, 23, 34, 45",
            "4, 23, 65, 34, 24, 77",
            "22, 22, 43, 21, 1, 2"})
    void 당첨번호_번호_입력시_validation(String input) {
        //given
        List<Integer> winningNumberList = LottoNumberParser.parseLottoNumberToList(input);

        //when, then
        assertThatThrownBy(() -> new WinningLotto(winningNumberList, 33)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 validation test")
    @ParameterizedTest
    @ValueSource(ints = {
            0, 46, 100, 1000, -30
    })
    void 보너스_번호_validation(int input) {
        //given
        List<Integer> dummy = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when, then
        assertThatThrownBy(() -> new WinningLotto(dummy, input)).isInstanceOf(IllegalArgumentException.class);
    }
}
