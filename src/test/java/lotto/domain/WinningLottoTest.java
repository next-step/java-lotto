package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.utils.FixNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    private WinningLotto winningLotto;

    private static final List<Integer> winningNumbers = new ArrayList<>(
        Arrays.asList(1, 3, 4, 5, 6, 7));
    private static final int bonusBall = 8;

    void setUp() {
        winningLotto = new WinningLotto(new FixNumberStrategy(winningNumbers), bonusBall);
    }

    @Test
    @DisplayName("주어진 번호와 일치하는 추첨 번호 로또를 생성한다.")
    void create_winning_lotto() {
        //given
        setUp();

        //when
        List<LottoNumber> lottoNumbers = winningLotto.getLottoNumber();

        //then
        assertTrue(Arrays.equals(lottoNumbers.toArray(),
            winningNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList())
                .toArray()));
    }

    @ParameterizedTest
    @MethodSource("lotto")
    @DisplayName("당첨번호와 일치하는 로또 번호의 갯수와 보너스볼과의 일치 정보를 올바르게 반환한다.")
    void get_matchCount(List<Lotto> lottos, List<Integer> matchCounts,
        List<Boolean> matchBonusBall) {
        //given
        setUp();

        //when
        List<MatchResult> matchResult = winningLotto.matchResults(lottos);

        //then
        for (int i = 0; i < lottos.size(); i++) {
            assertEquals(matchResult.get(i).getMatchCount(), matchCounts.get(i));
            assertEquals(matchResult.get(i).isMatchBonusBall(), matchBonusBall.get(i));
            System.out.println(matchResult.get(i).isMatchBonusBall());
        }
    }

    private static Stream<Arguments> lotto() {
        return Stream.of(
            Arguments.of(new ArrayList<>(Arrays.asList(
                new Lotto(new FixNumberStrategy(Arrays.asList(1, 3, 4, 5, 7, 9)))
                , new Lotto(new FixNumberStrategy(Arrays.asList(1, 3, 4, 5, 6, 8)))))
                , new ArrayList<>(Arrays.asList(5, 5))
                , new ArrayList<>(Arrays.asList(false, true)))
        );
    }

}