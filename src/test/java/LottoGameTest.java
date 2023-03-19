import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Set;
import lottoGame.InputView;
import lottoGame.Lotto;
import lottoGame.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameTest {

    private final int LOTTO_ONE_GAME_AMT = 1000;

    @DisplayName("구입금액 1000원당 6자리의 로또를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2000"})
    void buyLotto(String amt) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.buyLotto(amt);
        assertThat(lottoGame.getLottoListCount()).isEqualTo(Integer.parseInt(amt)/LOTTO_ONE_GAME_AMT);
    }
    @DisplayName("일등 당첨 확인")
    @Test
    void getFirstGrade() {
        LottoGame lottoGame = new LottoGame();
        final var actual = lottoGame.matchingLotto(List.of(1,2,3,4,5,6), Set.of(1,2,3,4,5,6), 7);
        assertThat(actual).isEqualTo(1);
    }
    @DisplayName("이등 당첨 확인")
    @Test
    void getSecondGrade() {
        LottoGame lottoGame = new LottoGame();
        final var actual = lottoGame.matchingLotto(List.of(1,2,3,4,5,7), Set.of(1,2,3,4,5,6), 7);
        assertThat(actual).isEqualTo(2);
    }
    @DisplayName("삼등 당첨 확인")
    @Test
    void getThirdGrade() {
        LottoGame lottoGame = new LottoGame();
        final var actual = lottoGame.matchingLotto(List.of(1,2,3,4,5,8), Set.of(1,2,3,4,5,6), 7);
        assertThat(actual).isEqualTo(3);
    }
    @DisplayName("사등 당첨 확인")
    @Test
    void getFourthGrade() {
        LottoGame lottoGame = new LottoGame();
        final var actual = lottoGame.matchingLotto(List.of(1,2,3,4,8,9), Set.of(1,2,3,4,5,6), 7);
        assertThat(actual).isEqualTo(4);
    }
    @DisplayName("오등 당첨 확인")
    @Test
    void getFifthGrade() {
        LottoGame lottoGame = new LottoGame();
        final var actual = lottoGame.matchingLotto(List.of(1,2,3,8,9,10), Set.of(1,2,3,4,5,6), 7);
        assertThat(actual).isEqualTo(5);
    }
    @DisplayName("로또 번호 6개를 반환한다.")
    @Test
    void getLottoNumber() {
        Lotto lotto = new Lotto();
        System.out.println(lotto.getLottoNumber());
    }
}
