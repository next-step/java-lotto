package autolotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
