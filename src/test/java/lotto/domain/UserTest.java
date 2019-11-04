package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    void 로또_구매_및_확인() {
        User user = new User(1000);
        user.buyLottoIn(new Store(new BasicLottoMachine(new TestNumberGenerator())));
        user.checkLottoRank("1, 2, 3, 4, 5, 6", "7");
        assertThat(user.getCountByRank(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void 로또_수익률() {
        User user = new User(1000);
        user.buyLottoIn(new Store(new BasicLottoMachine(new TestNumberGenerator())));
        user.checkLottoRank("1, 2, 3, 7, 8, 9", "10");
        assertThat(user.calculateRate()).isEqualTo(5.00);
    }

    @Test
    void 보너스_번호_포함_당첨번호확인() {
        User user = new User(1000);
        user.buyLottoIn(new Store(new BasicLottoMachine(new TestNumberGenerator())));
        user.checkLottoRank("1, 2, 3, 4, 10, 11", "5");
        assertThat(user.getCountByRank(Rank.SECOND)).isEqualTo(1);
    }

    private static class TestNumberGenerator implements NumberGenerator {

        private static final int LOTTO_NUMBER_COUNT = 6;
        private static final int LOTTO_NUMBER_LIMIT = 6;

        private final List<Integer> totalNumbers;

        TestNumberGenerator() {
            this.totalNumbers = new ArrayList<>();
            for (int i = 1; i < LOTTO_NUMBER_LIMIT + 1; i++) {
                totalNumbers.add(i);
            }
        }
        @Override
        public List<Integer> generate() {
            List<Integer> lottoNumbers = new ArrayList<>(totalNumbers.subList(0, LOTTO_NUMBER_COUNT));
            return Collections.unmodifiableList(lottoNumbers);
        }

    }
}
