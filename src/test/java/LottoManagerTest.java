import domain.Lotto;
import domain.LottoManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoManagerTest {


    @ParameterizedTest
    @CsvSource(value = {"14000,14", "6500,6"})
    public void 로또구매가격으로_구입개수만들기_테스트(int purchaseAmount, int result) {
        LottoManager lottoManager = new LottoManager(purchaseAmount);
        assertThat(lottoManager.getPurchaseLottoCount(purchaseAmount)).isEqualTo(result);
    }


    @Test
    public void 당첨로또_생성_테스트() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);

        LottoManager lottoManager = new LottoManager();
        Lotto winningLotto = new Lotto(() -> lottoNumbers);

        assertThat(lottoManager.makeWinningLotto(() -> lottoNumbers)).isEqualTo(winningLotto);

    }

}
