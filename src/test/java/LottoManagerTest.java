import domain.Lotto;
import domain.LottoManager;
import domain.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoManagerTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    public void 로또넘버사전생성() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
    }


    @ParameterizedTest
    @CsvSource(value = {"14000,14", "6500,6"})
    public void 로또구매가격으로_구입개수만들기_테스트(int purchaseAmount, int result) {
        LottoManager lottoManager = new LottoManager(purchaseAmount, new int[0][]);
        assertThat(Lotto.calcPurchaseLottoCount(purchaseAmount)).isEqualTo(result);
    }


    @Test
    public void 당첨로또_생성_테스트() {
        LottoManager lottoManager = new LottoManager();
        Lotto winningLotto = new Lotto(() -> lottoNumbers);

        assertThat(lottoManager.makeLotto(() -> lottoNumbers)).isEqualTo(winningLotto);
    }

    @Test
    public void 로또생성_테스트() {
        LottoManager lottoManager = new LottoManager();
        assertThat(lottoManager.makeLotto(() -> lottoNumbers)).isEqualTo(new Lotto(() -> lottoNumbers));
    }

}
