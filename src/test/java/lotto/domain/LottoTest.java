package lotto.domain;

import lotto.LottoConfig;
import org.junit.jupiter.api.Test;

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
        List<Integer> actual = new Lotto(input).getLotto();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 로도번호_랜덤테스트_검증() {
        Lotto lotto = new Lotto();
        List<Integer> actualLotto = lotto.getLotto();

        int actualSize = new HashSet<>(actualLotto).size();
        assertThat(actualSize).isEqualTo(LottoConfig.LOTTO_SIZE);

        //정렬여부 확인
        List<Integer> expectOrderedList = actualLotto.stream()
                .sorted()
                .collect(Collectors.toList());
        assertThat(actualLotto).isEqualTo(expectOrderedList);

        boolean actualLottoNumberConfirm = actualLotto.stream()
                .anyMatch(number -> (number < LottoConfig.LOTTO_START_NUMBER || number > LottoConfig.LOTTO_LAST_NUMBER));
        assertThat(actualLottoNumberConfirm).isEqualTo(false);
    }

    @Test
    void 예외_범위_테스트_음수() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, -1);

        assertThatThrownBy(() -> {
            lotto = new Lotto(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoConfig.LOTTO_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 예외_범위_테스트_0() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 0);

        assertThatThrownBy(() -> {
            lotto = new Lotto(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoConfig.LOTTO_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 예외_범위_테스트_46() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> {
            lotto = new Lotto(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoConfig.LOTTO_NUMBER_ERROR_MESSAGE);
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
                .hasMessageContaining(LottoConfig.LOTTO_SIZE_ERROR_MESSAGE);
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
                .hasMessageContaining(LottoConfig.LOTTO_SIZE_ERROR_MESSAGE);
    }

    @Test
    void 예외_로또번호중복_테스트() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> {
            lotto = new Lotto(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoConfig.LOTTO_SIZE_ERROR_MESSAGE);
    }
}
