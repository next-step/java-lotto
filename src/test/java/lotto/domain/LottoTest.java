package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class LottoTest {
    Lotto lotto;

    @Test
    void 로또번호_입력테스트() {
        List<Integer> input = Arrays.asList(1, 6, 3, 4, 5, 2);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = new Lotto(input).getValue();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 예외_범위_테스트_음수() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, -1);

        assertThatThrownBy(() -> lotto = new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoNumber.LOTTO_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 예외_범위_테스트_0() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 0);

        assertThatThrownBy(() -> {
            lotto = new Lotto(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoNumber.LOTTO_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 예외_범위_테스트_46() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> {
            lotto = new Lotto(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoNumber.LOTTO_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 예외_로또크기초과_테스트() {
        List<Integer> input = IntStream.rangeClosed(1, 7)
                .boxed()
                .collect(Collectors.toList());

        assertThatThrownBy(() -> {
            lotto = new Lotto(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Lotto.LOTTO_SIZE_ERROR_MESSAGE);
    }

    @Test
    void 예외_로또크기부족_테스트() {
        List<Integer> input = IntStream.rangeClosed(1, 5)
                .boxed()
                .collect(Collectors.toList());

        assertThatThrownBy(() -> {
            lotto = new Lotto(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Lotto.LOTTO_SIZE_ERROR_MESSAGE);
    }

    @Test
    void 예외_로또번호중복_테스트() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> {
            lotto = new Lotto(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Lotto.LOTTO_SIZE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 6",
            "2, 5",
            "5, 2",
            "6, 1",
            "30, 0"
    })
    void 당첨번호_테스트(int start, int expected) {
        Lotto winningLottery = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(IntStream.rangeClosed(start, start + 5).boxed().collect(Collectors.toList()));
        int actual = lotto.sameLottoNumberCount(winningLottery);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 예외_null_테스트() {
        assertThatThrownBy(() -> {
            lotto = new Lotto(null);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Lotto.LOTTO_NULL_MESSAGE);
    }
}
