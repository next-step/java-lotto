package lotto;

import org.junit.jupiter.api.Test;
import random.DefaultLottoList;
import random.LottoGenerateStrategy;
import random.LottoGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    public static final int TEST_TRY_LOTTO_COUNT = 3;
    private LottoGenerator lottoGenerator = new LottoGenerateStrategy(new DefaultLottoList());

    @Test
    public void 금액_개수_변환테스트() {
        int purchaseAmount = 3000;
        Lotto lotto = Lotto.InitLotto(purchaseAmount);
        assertThat(lotto).isEqualTo(new Lotto(new TryLottoCount(TEST_TRY_LOTTO_COUNT)));
    }

    @Test
    public void 로또번호_생성테스트() {
        int purchaseAmount = 1000;
        Lotto lotto = Lotto.InitLotto(purchaseAmount);
        OneTimeRoundLottoNumberList testNumberList = new OneTimeRoundLottoNumberList(lottoGenerator.executeStrategy());
        LottoNumberList lottoNumberList = new LottoNumberList(List.of(testNumberList));

        lotto.makeLottoList(lottoGenerator);
        assertThat(lotto).isEqualTo(new Lotto(new TryLottoCount(1),lottoNumberList));
    }

}
