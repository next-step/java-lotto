package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import random.DefaultLottoList;
import random.LottoGenerateStrategy;
import random.LottoGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    public static final int TEST_TRY_LOTTO_COUNT = 3;
    public static final String TEST_LOTTO_WINNER_NUMBERS = "4, 5, 6, 7, 8, 9";
    public static final List<Integer> TEST_LOTTO_GENERATED_NUMBER_LIST = List.of(1, 2, 3, 4, 5, 6);
    private LottoGenerator lottoGenerator = new LottoGenerateStrategy(new DefaultLottoList());

    @BeforeEach
    void setup() {}


    @Test
    public void 금액_개수_변환테스트() {
        int purchaseAmount = 3000;
        Lotto lotto = Lotto.InitLotto(purchaseAmount, lottoGenerator);
        lotto.convertPurchaseToLottoTryCount(purchaseAmount);
        assertThat(lotto).isEqualTo(new Lotto(new TryLottoCount(TEST_TRY_LOTTO_COUNT)));
    }

    @Test
    public void 로또번호_생성테스트() {
        int purchaseAmount = 1000;
        Lotto lotto = new Lotto(new TryLottoCount(0));
        lotto.convertPurchaseToLottoTryCount(purchaseAmount);
        lotto.makeLottoList(lottoGenerator);

        OneTimeRoundLottoNumberList testNumberList = new OneTimeRoundLottoNumberList(lottoGenerator.executeStrategy());
        LottoNumberList lottoNumberList = new LottoNumberList(List.of(testNumberList));

        assertThat(lotto).isEqualTo(new Lotto(new TryLottoCount(1),lottoNumberList));
    }

    @Test
    public void searchWinningCount_당첨횟수_테스트() {
        int purchaseAmount = 1000;
        Lotto lotto = Lotto.InitLotto(purchaseAmount, lottoGenerator);
        String lottoWinnerNumbers = TEST_LOTTO_WINNER_NUMBERS;
        LottoWinner lottoWinner = new LottoWinner(lottoWinnerNumbers);
        lotto.searchWinningCount(lottoWinner);

        OneTimeRoundLottoNumberList testNumberList = new OneTimeRoundLottoNumberList(TEST_LOTTO_GENERATED_NUMBER_LIST);
        LottoNumberList testLottoNumberList = new LottoNumberList(List.of(testNumberList));

        Lotto testLotto = new Lotto(new TryLottoCount(1), testLottoNumberList);

        assertThat(lotto).isEqualTo(testLotto);
    }

}
