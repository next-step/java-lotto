package lotto.domain2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @ParameterizedTest
    @ValueSource(ints = 10_000)
    void 생성(final int money) {
        User user = new User(money);
        assertThat(user).isEqualTo(new User(money));
    }

    @ParameterizedTest
    @ValueSource(ints = 1_000)
    void 로또구매_당첨(final int money) {
        User user = new User(money);
        user.buyLottosIn(new Store(new TestLottoMachine()));
        WinningLottos winningLottos = user.checkLottos("1, 2, 3, 4, 5, 6", 7);
        assertThat(winningLottos.getCountOf(Rank.FIRST)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = 1_000)
    void 로또구매_2등당첨(final int money) {
        User user = new User(money);
        user.buyLottosIn(new Store(new TestLottoMachine()));
        WinningLottos winningLottos = user.checkLottos("1, 2, 3, 4, 10, 11", 6);
        assertThat(winningLottos.getCountOf(Rank.SECOND)).isEqualTo(1);
    }

    private static class TestLottoMachine implements LottoMachine {
        private final List<LottoNumber> baseLottoNumbers;

        TestLottoMachine() {
            this.baseLottoNumbers = new ArrayList<>();

            for (int no = 1; no <= 6; no++) {
                baseLottoNumbers.add(LottoNumber.of(no));
            }
        }

        @Override
        public Lottos issue(int countOfLotto) {
            final List<Lotto> lottos = new ArrayList<>();

            for (int i = 0; i < countOfLotto; i++) {
                Lotto lotto = new Lotto(baseLottoNumbers);
                lottos.add(lotto);
            }

            return new Lottos(lottos);
        }
    }
}
