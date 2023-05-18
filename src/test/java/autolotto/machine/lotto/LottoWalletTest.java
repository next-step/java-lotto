package autolotto.machine.lotto;

import autolotto.machine.BonusNumber;
import autolotto.machine.lotto.fixture.FixedNumberShuffler;
import autolotto.machine.winning.Winning;
import autolotto.machine.winning.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.Arrays;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoWalletTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator(new FixedNumberShuffler());
    private final WinningNumbers fixedWinningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 40, 41, 42));
    private final BonusNumber bonusAnyLottoNotContaining = new BonusNumber(11);

    @Test
    void 지갑에_로또를_하나_추가할_수_있다() {
        LottoWallet wallet = new LottoWallet();

        wallet.addLotto(lottoGenerator.generateLotto());

        Assertions.assertThat(wallet.lottoSize()).isEqualTo(1);
    }

    @Test
    void 지갑을_생성하며_한번에_로또_여러개를_추가_할_수_있다() {
        int three = 3;

        LottoWallet wallet = new LottoWallet(lottoGenerator.generateMultipleLotto(three));

        Assertions.assertThat(wallet.lottoSize()).isEqualTo(3);
    }

    @Test
    void 지갑_내_로또들이_모두_당첨_로또인_경우에_대한_총_당첨금액을_알려준다() {
        LottoWallet wallet = new LottoWallet(lottoGenerator.generateMultipleLotto(3));
        int expectedTotalWinnings = Winning.THREE.winningMoney() * 3;

        int totalWinnings = wallet.totalWinningMoneyOf(fixedWinningNumbers, bonusAnyLottoNotContaining);

        Assertions.assertThat(totalWinnings).isEqualTo(expectedTotalWinnings);
    }

    @Test
    void 지갑_내_당첨로또와_당첨이아닌_로또가_섞여있는_경우_총_당첨금액을_알려준다() {
        LottoWallet wallet = new LottoWallet(Arrays.asList(new Lotto(Arrays.asList(1, 22, 32, 24, 25, 26)),
                new Lotto(Arrays.asList(1, 2, 23, 24, 25, 27)),
                new Lotto(Arrays.asList(1, 2, 3, 24, 25, 28))));
        int expectedTotalWinnings = Winning.THREE.winningMoney();

        int totalWinnings = wallet.totalWinningMoneyOf(fixedWinningNumbers, bonusAnyLottoNotContaining);

        Assertions.assertThat(totalWinnings).isEqualTo(expectedTotalWinnings);
    }

    @Nested
    class countOfLottoMatchingWithTest {
        private LottoWallet wallet;

        @BeforeEach
        void setUp() {
            wallet = new LottoWallet(lottoGenerator.generateMultipleLotto(3));
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
