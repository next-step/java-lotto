package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static autoLotto.model.LottoConstants.INVALID_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinCheckerTest {

    private static final String VALID_NUMBERS_STRING_FIRST = "1,2,3,4,5,6";
    private static final String VALID_NUMBERS_STRING_SECOND = "31,33,34,35,36,37";
    private static final String OUT_OF_RANGE_NUMBERS_STRING = "1,2,3,4,5,6,7";
    private static final String INVALID_NUMBERS_STRING = "-1,-2,-3,-4,15,63,127";
    private static final List<Integer> VALID_NUMBERS_LIST_FIRST = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
    private static final List<Integer> VALID_NUMBERS_LIST_SECOND = new ArrayList<>(Arrays.asList(11,12,13,14,15,16));

    @Test
    @DisplayName("LottoWinChecker 객체 생성 성공 (0개 맞춘 로또 1개, 6개 모두 맞춘 로또 1개)")
    void testLottoWinChecker_ShouldReturnCorrectWinLottos() {
        // given
        List<Lotto> lottos = List.of(new Lotto(VALID_NUMBERS_LIST_FIRST), new Lotto(VALID_NUMBERS_LIST_SECOND));

        // when
        LottoWinChecker lottoWinChecker = new LottoWinChecker(VALID_NUMBERS_STRING_FIRST, lottos);
        HashMap<Integer, Integer> winLottos = lottoWinChecker.getWinLottos();

        // then
        assertThat(winLottos.size()).isEqualTo(1);
        assertThat(winLottos.get(6)).isEqualTo(1);
    }

    @Test
    @DisplayName("LottoWinChecker 객체 생성 성공 (0개 맞춘 로또 2개)")
    void testLottoWinChecker_NoMatchingWinNumbers_ShouldReturnCorrectWinLottos() {
        // given
        List<Lotto> lottos = List.of(new Lotto(VALID_NUMBERS_LIST_FIRST), new Lotto(VALID_NUMBERS_LIST_SECOND));

        // when
        LottoWinChecker lottoWinChecker = new LottoWinChecker(VALID_NUMBERS_STRING_SECOND, lottos);
        HashMap<Integer, Integer> winLottos = lottoWinChecker.getWinLottos();

        // then
        assertThat(winLottos.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("LottoWinChecker 객체 생성 실패 (당첨 번호가 제한된 개수 6개 보다 많이 입력됨)")
    void testLottoWinChecker_OutOfRangeWinNumbers_ShouldThrowException() {
        // given
        List<Lotto> lottos = List.of(new Lotto(VALID_NUMBERS_LIST_FIRST), new Lotto(VALID_NUMBERS_LIST_SECOND));

        // when, then
        assertThatThrownBy(() -> new LottoWinChecker(OUT_OF_RANGE_NUMBERS_STRING, lottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBERS);
    }

    @Test
    @DisplayName("LottoWinChecker 객체 생성 실패 (당첨 번호가 1 ~ 45가 아닌 그 이외의 값이 입력됨)")
    void testLottoWinChecker_InvalidWinNumbers_ShouldThrowException() {
        // given
        List<Lotto> lottos = List.of(new Lotto(VALID_NUMBERS_LIST_FIRST), new Lotto(VALID_NUMBERS_LIST_SECOND));

        // when, then
        assertThatThrownBy(() -> new LottoWinChecker(INVALID_NUMBERS_STRING, lottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBERS);
    }


}
