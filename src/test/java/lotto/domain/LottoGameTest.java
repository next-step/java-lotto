package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import lotto.utils.FixNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGameTest {

    @Test
    @DisplayName("주어진 갯수대로 랜덤 로또리스트를 가진 로또게임을 생성한다.")
    void create_lotto_game() {
        //given
        int number = 2;
        int manualCount = 0;

        //when
        LottoGame lottoGame = new LottoGame(number,manualCount);
        lottoGame.addRandomLotto();

        //then
        assertEquals(lottoGame.getLottos().size(), number);
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


}