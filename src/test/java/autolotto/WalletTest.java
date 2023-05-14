package autolotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class WalletTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator(new OriginalOrderShuffler());

    @Test
    void 지갑에_로또를_하나_추가할_수_있다() {
        int money = 1000;

        Wallet wallet = new Wallet(money);
        wallet.addLotto(lottoGenerator.generateLotto());

        Assertions.assertThat(wallet.lottoSize()).isEqualTo(1);
    }

    @Test
    void 지갑을_생성하며_한번에_로또_여러개를_추가_할_수_있다() {
        int threeLottoMoney = 3000;

        Wallet wallet = new Wallet(threeLottoMoney,
                lottoGenerator.generateLottos(threeLottoMoney));

        Assertions.assertThat(wallet.lottoSize()).isEqualTo(3);
    }

    @Test
    void 지갑_내_로또들에_대한_총_당첨금액을_알려준다() {
        Wallet wallet = new Wallet(3000,
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)),
                        new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)),
                        new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13))
                ));
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 22, 23, 24);
        int expectedTotalWinnings = Winning.THREE.winningMoney() * 3;


        int totalWinnings = wallet.totalWinningsOfWinningNumber(winningNumber);

        Assertions.assertThat(totalWinnings).isEqualTo(expectedTotalWinnings);
    }

    @Test
    void 로또구매금액_대비_당첨금액의_수익률을_소수점_둘째_자리까지_반올림한_값으로_알려준다() {
        int initialMoney = 3000;
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 22, 23, 24);
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 11, 12, 13);

        BigDecimal expectedProfitRate = new BigDecimal("5.00");
        Wallet wallet =
                new Wallet(initialMoney,
                        Arrays.asList(
                                new Lotto(lottoNumber),
                                new Lotto(lottoNumber),
                                new Lotto(lottoNumber)));

        BigDecimal profitRate = wallet.profitRate(winningNumber);

        Assertions.assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

    @Nested
    class 지갑_내_로또들_중_로또의_개수 {
        private Wallet wallet;
        private List<Integer> winningNumber;

        @BeforeEach
        void setUp() {
            wallet = new Wallet(3000,
                    Arrays.asList(
                            new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)),
                            new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)),
                            new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13))
                    ));
            winningNumber = Arrays.asList(1, 2, 3, 22, 23, 24);
        }

        @Test
        void 당첨번호와_정확히_3개_일치하는_로또의_개수를_알려준다() {
            int countOfMatchingNumber = 3;
            int countOfLotto = wallet.countOfLottoMatchingWith(winningNumber, countOfMatchingNumber);

            Assertions.assertThat(countOfLotto).isEqualTo(3);

        }

        @Test
        void 당첨번호와_정확히_2개_일치하는_로또의_개수를_알려준다() {
            int countOfMatchingNumber = 2;
            int countOfLotto = wallet.countOfLottoMatchingWith(winningNumber, countOfMatchingNumber);

            Assertions.assertThat(countOfLotto).isEqualTo(0);

        }
    }

}
