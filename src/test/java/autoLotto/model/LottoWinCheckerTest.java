package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinCheckerTest {

    private static final int WIN_LOTTO_SIZE = 5;
    private static final String WIN_NUMBERS_STRING = "1,2,3,4,5,6";
    private static final String OUT_OF_RANGE_NUMBERS_STRING = "1,2,3,4,5,6,7";
    private static final String INVALID_NUMBERS_STRING = "-1,-2,-3,-4,15,63,127";
    private static final Lotto LOTTO_FIRST = new Lotto(new int[]{1,2,3,4,5,6});
    private static final Lotto LOTTO_SECOND = new Lotto(new int[]{10,11,12,13,14,15});
    private static final String INVALID_WIN_NUMBERS = "당첨 번호의 개수는 6개이며, 각 번호는 1 이상 45 이하의 값만 가능합니다.";

    @ParameterizedTest(name = ("LottoWinChecker 객체 생성 : 성공 (0개 맞춘 로또 1개, 6개 모두 맞춘 로또 1개)"))
    @CsvSource(value = {"0:1", "1:0", "2:0", "3:0", "4:1"}, delimiter = ':')
    void testLottoWinChecker_ShouldReturnCorrectWinLottos(int index, int number) {
        // given
        List<Lotto> lottos = List.of(LOTTO_FIRST, LOTTO_SECOND);

        // when
        LottoWinChecker lottoWinChecker = new LottoWinChecker(WIN_NUMBERS_STRING, lottos);
        int[] winLottos = lottoWinChecker.getWinLottos();

        // then
        assertThat(winLottos.length).isEqualTo(WIN_LOTTO_SIZE);
        assertThat(winLottos[index]).isEqualTo(number);
    }

    @Test
    @DisplayName("LottoWinChecker 객체 생성 : 실패 (당첨 번호가 예상 개수 보다 많이 입력됨)")
    void testLottoWinChecker_NoMatchingWinNumbers_ShouldReturnCorrectWinLottos() {
        // given
        String winNumbersInString = "21,22,23,24,25,26";
        List<Lotto> lottos = List.of(LOTTO_FIRST, LOTTO_SECOND);

        // when
        LottoWinChecker lottoWinChecker = new LottoWinChecker(winNumbersInString, lottos);
        int[] winLottos = lottoWinChecker.getWinLottos();

        // then
        assertThat(winLottos.length).isEqualTo(WIN_LOTTO_SIZE);
        assertThat(winLottos[0]).isEqualTo(2);
    }

    @Test
    @DisplayName("LottoWinChecker 객체 생성 : 실패 (당첨 번호가 예상 개수 보다 많이 입력됨)")
    void testLottoWinChecker_OutOfRangeNumbers_ShouldThrowException() {
        // given
        List<Lotto> lottos = List.of(LOTTO_FIRST, LOTTO_SECOND);

        // when, then
        assertThatThrownBy(() -> new LottoWinChecker(OUT_OF_RANGE_NUMBERS_STRING, lottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_WIN_NUMBERS);
    }

    @Test
    @DisplayName("LottoWinChecker 객체 생성 : 실패 (1 ~ 45가 아닌 그 이외의 값이 입력됨)")
    void testLottoWinChecker_InvalidNumbers_ShouldThrowException() {
        // given
        List<Lotto> lottos = List.of(LOTTO_FIRST, LOTTO_SECOND);

        // when, then
        assertThatThrownBy(() -> new LottoWinChecker(INVALID_NUMBERS_STRING, lottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_WIN_NUMBERS);
    }


}
