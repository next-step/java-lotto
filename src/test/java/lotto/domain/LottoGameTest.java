package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.FixNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    private LottoGame lottoGame;
    private Lotto firstLotto;
    private Lotto secondLotto;

    private static final Set<Integer> winningNumbers =
        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final List<Integer> firstFixNumbers =
        new ArrayList<>(Arrays.asList(1, 3, 4, 5, 7, 9));
    private static final List<Integer> secondFixNumbers =
        new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 8));

    void setUp() {
        firstLotto = new Lotto(new FixNumberStrategy(firstFixNumbers));
        secondLotto = new Lotto(new FixNumberStrategy(secondFixNumbers));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(firstLotto);
        lottos.add(secondLotto);

        lottoGame = new LottoGame(lottos);
    }

    @Test
    @DisplayName("주어진 갯수대로 랜덤 로또리스트를 가진 로또게임을 생성한다.")
    void create_lotto_game() {
        //given
        int number = 2;

        //when
        LottoGame lottoGame = new LottoGame(number);

        //then
        assertEquals(lottoGame.getLottos().size(), number);
    }

    @Test
    @DisplayName("추첨 번호를 이용하여 올바를 로또 결과를 반환한다.")
    void match_counts_with_winning_numbers() {
        //given
        setUp();

        //when
        LottoResult lottoResult = lottoGame.draw(winningNumbers);

        //then
        assertEquals(lottoResult.getMatchResult().get(MatchType.FOUR), 1);
        assertEquals(lottoResult.getMatchResult().get(MatchType.FIVE), 1);
    }


}