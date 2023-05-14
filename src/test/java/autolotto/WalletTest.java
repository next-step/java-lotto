package autolotto;

import autolotto.lotto.LottoGenerator;
import autolotto.lotto.fixture.FixedNumberShuffler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WalletTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator(new FixedNumberShuffler());
    private final WinningNumbers fixedWinningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 22, 23, 24));

    @Test
    void 지갑에_로또를_하나_추가할_수_있다() {
        Wallet wallet = new Wallet();

        wallet.addLotto(lottoGenerator.generateLotto());

        Assertions.assertThat(wallet.lottoSize()).isEqualTo(1);
    }

    @Test
    void 지갑을_생성하며_한번에_로또_여러개를_추가_할_수_있다() {
        int three = 3;

        Wallet wallet = new Wallet(lottoGenerator.generateMultipleLotto(three));

        Assertions.assertThat(wallet.lottoSize()).isEqualTo(3);
    }

    @Test
    void 지갑_내_로또들에_대한_총_당첨금액을_알려준다() {
        Wallet wallet = new Wallet(lottoGenerator.generateMultipleLotto(3));
        int expectedTotalWinnings = Winning.THREE.winningMoney() * 3;

        int totalWinnings = wallet.totalWinningMoneyOf(fixedWinningNumbers);

        Assertions.assertThat(totalWinnings).isEqualTo(expectedTotalWinnings);
    }

    @Nested
    class 지갑_내_로또들_중_로또의_개수 {
        private Wallet wallet;

        @BeforeEach
        void setUp() {
            wallet = new Wallet(lottoGenerator.generateMultipleLotto(3));
        }

        @Test
        void 당첨번호와_정확히_3개_일치하는_로또의_개수를_알려준다() {
            int countOfMatchingNumber = 3;
            int countOfLotto = wallet.countOfLottoMatchingWith(fixedWinningNumbers, countOfMatchingNumber);

            Assertions.assertThat(countOfLotto).isEqualTo(3);

        }

        @Test
        void 당첨번호와_정확히_2개_일치하는_로또의_개수를_알려준다() {
            int countOfMatchingNumber = 2;
            int countOfLotto = wallet.countOfLottoMatchingWith(fixedWinningNumbers, countOfMatchingNumber);

            Assertions.assertThat(countOfLotto).isEqualTo(0);
        }
    }

}
