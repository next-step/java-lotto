package autolotto.machine.lotto;

import autolotto.machine.LottoUtil;
import autolotto.machine.lotto.fixture.FixedNumberShuffler;
import autolotto.machine.winning.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.Arrays;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoWalletTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator(new FixedNumberShuffler());
    private final WinningNumbers fixedWinningNumbers = new WinningNumbers(
            LottoUtil.createLottoNumbers(Arrays.asList(1, 2, 3, 40, 41, 42)),
            new LottoNumber(11));

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
