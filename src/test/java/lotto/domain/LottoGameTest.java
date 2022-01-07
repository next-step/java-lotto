package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.utils.FixNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGameTest {

    @ParameterizedTest
    @MethodSource("lottoCount")
    @DisplayName("주어진 매뉴얼 숫자대로 생성된 로또를 로또 목록에 추가한다.")
    void lotto_game_with_manual_numbers(int totalCount, int manualCount,
        List<Set<Integer>> manualNumbers) {
        //given

        //when
        LottoGame lottoGame = new LottoGame(totalCount, manualCount);
        manualNumbers.forEach(lottoGame::addManualLotto);

        //then
        assertEquals(lottoGame.getLottos().size(), manualCount);
        for (Set<Integer> manualNumber : manualNumbers) {
            assertThat(manualNumber.stream()
                .map(m -> LottoNumber.of(m))
                .collect(Collectors.toList())
                .equals(lottoGame.getLottos()));
        }
    }

    @ParameterizedTest
    @CsvSource({"1,0", "3,2", "7,2"})
    @DisplayName("주어진 매뉴얼 로또 갯수를 제외한 수 만큼 랜덤넘버를 이용한 로또를 생성한다.")
    void lotto_game_with_random_numbers(int totalCount, int manualCount) {
        //given

        //when
        LottoGame lottoGame = new LottoGame(totalCount, manualCount);
        lottoGame.addRandomLotto();

        //then
        assertEquals(lottoGame.getLottos().size(), totalCount - manualCount);
    }


    @ParameterizedTest
    @MethodSource("lottoGame")
    @DisplayName("추첨 번호를 이용하여 올바를 로또 결과를 반환한다.")
    void match_counts_with_winning_numbers(LottoGame lottoGame,
        Set<Integer> winningNumbers,
        int actual) {
        //given

        //when
        LottoResult lottoResult = lottoGame.draw(winningNumbers, 7);

        //then
        assertEquals(lottoResult.getResult().get(MatchType.FOUR), actual);
        assertEquals(lottoResult.getResult().get(MatchType.FIVE), actual);
    }

    private static Stream<Arguments> lottoGame() {
        return Stream.of(
            Arguments.of(new LottoGame(Arrays.asList(
                new Lotto(new FixNumberStrategy(Arrays.asList(1, 3, 4, 5, 7, 9))),
                new Lotto(new FixNumberStrategy(Arrays.asList(2, 3, 4, 5, 6, 8))))
            ), new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 1)
        );
    }

    private static Stream<Arguments> lottoCount() {
        return Stream.of(
            Arguments.of(5, 3, Arrays.asList(new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6))
                , new HashSet(Arrays.asList(2, 3, 4, 5, 6, 7))
                , new HashSet(Arrays.asList(3, 4, 5, 6, 7, 8)))
            )
            , Arguments.of(3, 2, Arrays.asList(new HashSet(Arrays.asList(12, 15, 16, 17, 18, 19))
                , new HashSet(Arrays.asList(34, 35, 36, 37, 38, 39))
            ))
        );
    }


}