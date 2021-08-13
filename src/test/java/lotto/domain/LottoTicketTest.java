package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTicketTest {
    private static Stream<Arguments> 로또공들의_생성자에_숫자배열을_6개가_아닌_다른_개수로_입력받으면_예외를_던진다() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 4, 5}),
            Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7})
        );
    }

    private static Stream<Arguments> 로또공들의_생성자에_숫자배열에_0과_45사이를_벗어나는_숫자를_입력받으면_예외를_던진다() {
        return Stream.of(
            Arguments.of(new int[] {0, 2, 3, 4, 5, 6}),
            Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 46})
        );
    }

    private static Stream<Arguments> 임의의_6개의_로또공들의_번호들과_로또공들의_우승자_번호가_주어질_때_일치하는_개수를_반환한다() {
        return Stream.of(
            Arguments.of(LottoTicket.of(1, 2, 3, 4, 5, 6), 6),
            Arguments.of(LottoTicket.of(1, 2, 3, 4, 5, 7), 5),
            Arguments.of(LottoTicket.of(1, 2, 3, 4, 7, 8), 4),
            Arguments.of(LottoTicket.of(1, 2, 3, 7, 8, 9), 3),
            Arguments.of(LottoTicket.of(1, 2, 7, 8, 9, 10), 2),
            Arguments.of(LottoTicket.of(1, 7, 8, 9, 10, 11), 1),
            Arguments.of(LottoTicket.of(7, 8, 9, 10, 11, 12), 0)
        );
    }

    @Test
    void 로또공들의_생성자에_숫자배열을_입력받으면_데이터를_초기화한다() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6)).isInstanceOf(LottoTicket.class);
    }

    @ParameterizedTest
    @MethodSource
    void 로또공들의_생성자에_숫자배열을_6개가_아닌_다른_개수로_입력받으면_예외를_던진다(int... numbers) {
        assertThatThrownBy(() -> LottoTicket.of(numbers))
            .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @MethodSource
    void 로또공들의_생성자에_숫자배열에_0과_45사이를_벗어나는_숫자를_입력받으면_예외를_던진다(int... numbers) {
        assertThatThrownBy(() -> LottoTicket.of(numbers))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 로또공들의_우승자_번호를_랜덤으로_만들면_로또공들의_객체가_생성된다() {
        assertThat(LottoTicket.createRandomNumber()).isInstanceOf(LottoTicket.class);
    }

    @ParameterizedTest
    @MethodSource
    void 임의의_6개의_로또공들의_번호들과_로또공들의_우승자_번호가_주어질_때_일치하는_개수를_반환한다(LottoTicket actual, int expected) {
        LottoTicket lottoTicket = LottoTicket.of(1, 2, 3, 4, 5, 6);
        assertThat(lottoTicket.countMatchNumber(actual)).isEqualTo(expected);
    }

    @Test
    void 임의의_6개의_로또공들의_번호에서_중복된_것이_존재한다면_예외를_던진다() {
        assertThatThrownBy(() -> LottoTicket.of(1, 1, 2, 3, 4, 5))
            .isInstanceOf(RuntimeException.class);
    }
}
