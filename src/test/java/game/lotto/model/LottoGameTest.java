package game.lotto.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 게임_만들기() {
        final Money money = new Money(3000);
        final Amount expectedAmount = new Amount(money);
        LottoGame lottoGame = new LottoGame(money);

        assertThat(lottoGame.getAmount()).isEqualTo(expectedAmount);
    }

    @Test
    public void 로또번호_맞춰보기() {
        final String stringWinningNumbers = "1, 2, 3, 4, 5, 6";
        final Set<LottoNumber> winningNumbers = LottoNumberFactory.createLottoNumbers(stringWinningNumbers);

        LottoGame lottoGame = new LottoGame(createMatchTestLottos());
        MatchResult matchResult = lottoGame.match(winningNumbers);

        assertThat(matchResult.getMatch(MatchType.MATCH_3).getCount()).as("3개 일치 갯수").isEqualTo(2);
        assertThat(matchResult.getMatch(MatchType.MATCH_4).getCount()).as("4개 일치 갯수").isEqualTo(1);
        assertThat(matchResult.getMatch(MatchType.MATCH_5).getCount()).as("5개 일치 갯수").isEqualTo(2);
        assertThat(matchResult.getMatch(MatchType.MATCH_6).getCount()).as("6개 일치 갯수").isEqualTo(3);
    }

    private List<Lotto> createMatchTestLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(create3MatchLotto());
        lottos.add(create3MatchLotto());
        lottos.add(create4MatchLotto());
        lottos.add(create5MatchLotto());
        lottos.add(create5MatchLotto());
        lottos.add(create6MatchLotto());
        lottos.add(create6MatchLotto());
        lottos.add(create6MatchLotto());

        return lottos;
    }

    private Lotto create3MatchLotto() {
        String matchNumbers = "1, 3, 5, 7, 9, 10";
        return creatMatchLotto(matchNumbers);
    }

    private Lotto create4MatchLotto() {
        String matchNumbers = "1, 3, 4, 5, 7, 9";
        return creatMatchLotto(matchNumbers);
    }

    private Lotto create5MatchLotto() {
        String matchNumbers = "1, 3, 4, 5, 6, 9";
        return creatMatchLotto(matchNumbers);
    }

    private Lotto create6MatchLotto() {
        String matchNumbers = "1, 2, 3, 4, 5, 6";
        return creatMatchLotto(matchNumbers);
    }

    private Lotto creatMatchLotto(String matchNumbers) {
        Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(matchNumbers);
        return new Lotto(lottoNumbers);
    }

}