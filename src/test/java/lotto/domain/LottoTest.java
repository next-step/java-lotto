package lotto.domain;

import org.junit.jupiter.api.Test;
import lotto.random.LottoGenerateStrategy;
import lotto.random.LottoGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    public static final int TEST_TRY_LOTTO_COUNT = 3;
     public static final List<Integer> TEST_LOTTO_GENERATED_NUMBER_LIST = List.of(1, 2, 3, 4, 5, 6);
    public static final int TEST_PURCHASE_AMOUNT = 3000;
    public static final int TEST_ONETIME_PURCHASE_AMOUNT = 1000;
    private LottoGenerator lottoGenerator = new LottoGenerateStrategy(new DefaultLottoList());



    @Test
    public void 금액_개수_변환테스트() {
        int purchaseAmount = TEST_PURCHASE_AMOUNT;
        Lotto lotto = Lotto.InitLotto(purchaseAmount, lottoGenerator);
        lotto.convertPurchaseToLottoTryCount();
        assertThat(lotto).isEqualTo(new Lotto(new TryLottoCount(TEST_TRY_LOTTO_COUNT, purchaseAmount)));
    }

    @Test
    public void 로또번호_생성테스트() {
        int purchaseAmount = TEST_ONETIME_PURCHASE_AMOUNT;
        Lotto lotto = new Lotto(new TryLottoCount(0, purchaseAmount));
        lotto.convertPurchaseToLottoTryCount();
        lotto.makeLottoList(lottoGenerator);

        OneTimeRoundLottoNumberList testNumberList = new OneTimeRoundLottoNumberList(lottoGenerator.executeStrategy());
        LottoNumberList lottoNumberList = new LottoNumberList(List.of(testNumberList));

        assertThat(lotto).isEqualTo(new Lotto(new TryLottoCount(1, purchaseAmount),lottoNumberList));
    }

    @Test
    public void recordWinningCount_당첨횟수_테스트() {
        int purchaseAmount = TEST_ONETIME_PURCHASE_AMOUNT;
        Lotto lotto = Lotto.InitLotto(purchaseAmount, lottoGenerator);
        LottoWinner lottoWinner = new LottoWinner(TEST_LOTTO_GENERATED_NUMBER_LIST);
        lotto.insertWinningLottoNumber(lottoWinner);
        lotto.recordWinningCount();

        OneTimeRoundLottoNumberList testNumberList = new OneTimeRoundLottoNumberList(TEST_LOTTO_GENERATED_NUMBER_LIST);
        LottoNumberList testLottoNumberList = new LottoNumberList(List.of(testNumberList));

        Lotto testLotto = new Lotto(new TryLottoCount(1, purchaseAmount), testLottoNumberList);

        assertThat(lotto).isEqualTo(testLotto);
    }

}
