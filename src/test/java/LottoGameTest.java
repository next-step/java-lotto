import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lottoGame.Lotto;
import lottoGame.Lotto.TYPE;
import lottoGame.LottoGame;
import lottoGame.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameTest {

    private final int LOTTO_ONE_GAME_AMT = 1000;

    @DisplayName("구입금액 1000원당 6자리의 로또를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {2000})
    void buyLotto(int amt) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.buyLotto(amt, null);
        assertThat(lottoGame.getLottoListCount()).isEqualTo(amt / LOTTO_ONE_GAME_AMT);
    }

    @DisplayName("일등 당첨 확인")
    @Test
    void getFirstGrade() {
        LottoGame lottoGame = new LottoGame();
        final var actual = lottoGame.matchingLotto(List.of(1, 2, 3, 4, 5, 6),
            Set.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(actual).isEqualTo(Rank.FIRST);
    }

    @DisplayName("이등 당첨 확인")
    @Test
    void getSecondGrade() {
        LottoGame lottoGame = new LottoGame();
        final var actual = lottoGame.matchingLotto(List.of(1, 2, 3, 4, 5, 7),
            Set.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(actual).isEqualTo(Rank.SECOND);
    }

    @DisplayName("삼등 당첨 확인")
    @Test
    void getThirdGrade() {
        LottoGame lottoGame = new LottoGame();
        final var actual = lottoGame.matchingLotto(List.of(1, 2, 3, 4, 5, 8),
            Set.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(actual).isEqualTo(Rank.THIRD);
    }

    @DisplayName("사등 당첨 확인")
    @Test
    void getFourthGrade() {
        LottoGame lottoGame = new LottoGame();
        final var actual = lottoGame.matchingLotto(List.of(1, 2, 3, 4, 8, 9),
            Set.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(actual).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("오등 당첨 확인")
    @Test
    void getFifthGrade() {
        LottoGame lottoGame = new LottoGame();
        final var actual = lottoGame.matchingLotto(List.of(1, 2, 3, 8, 9, 10),
            Set.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(actual).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("자동로또 번호 6개를 반환한다.")
    @Test
    void getLottoNumber() {
        for (int i = 0; i < 100; i++) {
            Lotto lotto = new Lotto(TYPE.AUTO, null);

            List<Integer> lottoNumbers = lotto.getLottoNumber();
            assertThat(lottoNumbers.size()).isEqualTo(6);

            Set<Integer> checkNumber = new HashSet<>(lottoNumbers);
            assertThat(checkNumber.size()).isEqualTo(6);

            for (int number : lottoNumbers) {
                assertThat(number).isBetween(1, 45);
            }
        }
    }

    @DisplayName("입력값 테스트.")
    @Test
    void checkInputData() {
        LottoGame lottoGame = new LottoGame();
        List<Lotto> manualLotto = Arrays.asList(
            new Lotto(TYPE.MANUAL, "1,2,3,4,5,6"),
            new Lotto(TYPE.MANUAL, "3,4,5,6,7,8"),
            new Lotto(TYPE.MANUAL, "10,12,13,14,25,26")
        );

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> lottoGame.buyLotto(500, null));

        assertThat(lottoGame.buyLotto(1000, null)).isEqualTo(1);

        assertThat(lottoGame.buyLotto(1500, null)).isEqualTo(1);

        assertThat(lottoGame.buyLotto(10000, manualLotto)).isEqualTo(7);

        lottoGame.buyLotto(10000, manualLotto);
        assertThat(lottoGame.getManualLottoCount()).isEqualTo(3);
    }
}
