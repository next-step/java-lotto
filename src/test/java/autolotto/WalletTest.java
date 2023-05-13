package autolotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
