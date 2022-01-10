package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import lotto.utils.FixNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGameTest {

    private static final int LOTTO_NUMBER_SIZE = 6;

    @ParameterizedTest
    @MethodSource("lottoCount")
    @DisplayName("주어진 매뉴얼 숫자대로 생성된 로또를 로또 목록에 추가한다.")
    void lotto_game_with_manual_numbers(int totalCount,
        List<Set<Integer>> manualNumbers) {
        //given
        ManualLottos manualLottos = new ManualLottos();
        manualNumbers.forEach(manualLottos::addManualLotto);

        //when
        LottoGame lottoGame = new LottoGame(totalCount, manualLottos);

        //then
        assertEquals(lottoGame.getLottoCount().getManualCount(),
            manualLottos.getManualLottos().size());

        for (int i = 0; i < manualNumbers.size(); i++) {
            List<LottoNumber> manualLotto = manualLottos.getManualLottos().get(i).getLottoNumber();
            List<LottoNumber> createdLotto = lottoGame.getLottos().get(i).getLottoNumber();
            compareLottNumbers(manualLotto, createdLotto);
        }
    }


    @ParameterizedTest
    @MethodSource("lottoCount")
    @DisplayName("주어진 매뉴얼 로또 갯수를 제외한 수 만큼 랜덤넘버를 이용한 로또를 생성한다.")
    void lotto_game_with_random_numbers(int totalCount,
        List<Set<Integer>> manualNumbers) {
        //given
        ManualLottos manualLottos = new ManualLottos();
        manualNumbers.forEach(manualLottos::addManualLotto);

        //when
        LottoGame lottoGame = new LottoGame(totalCount, manualLottos);

        //then
        assertEquals(lottoGame.getLottoCount().getAutoCount(), totalCount - manualNumbers.size());
    }


    @ParameterizedTest
    @MethodSource("lottoGame")
    @DisplayName("추첨 번호를 이용하여 올바를 로또 결과를 반환한다.")
    void match_counts_with_winning_numbers(LottoGame lottoGame,
        WinningLotto winningLotto, int actual) {
        //given

        //when
        LottoResult lottoResult = lottoGame.draw(winningLotto);

        //then
        assertEquals(lottoResult.getResult().get(MatchType.FOUR), actual);
        assertEquals(lottoResult.getResult().get(MatchType.FIVE), actual);
    }

    private static Stream<Arguments> lottoGame() {
        return Stream.of(
            Arguments.of(new LottoGame(Arrays.asList(
                new Lotto(new FixNumberStrategy(Arrays.asList(1, 3, 4, 5, 7, 9))),
                new Lotto(new FixNumberStrategy(Arrays.asList(2, 3, 4, 5, 6, 8))))
            ), new WinningLotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 1), 1)
        );
    }

    private static Stream<Arguments> lottoCount() {
        return Stream.of(
            Arguments.of(5, Arrays.asList(new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet(Arrays.asList(2, 3, 4, 5, 6, 7)),
                new HashSet(Arrays.asList(3, 4, 5, 6, 7, 8)))
            ),
            Arguments.of(3, Arrays.asList(new HashSet(Arrays.asList(12, 15, 16, 17, 18, 19)),
                new HashSet(Arrays.asList(34, 35, 36, 37, 38, 39))
            ))
        );
    }

    private void compareLottNumbers(List<LottoNumber> expected, List<LottoNumber> created) {
        for (int j = 0; j < LOTTO_NUMBER_SIZE; j++) {
            assertThat(expected.get(j).equals(created.get(j))).isTrue();
        }
    }


}