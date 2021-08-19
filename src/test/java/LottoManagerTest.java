import domain.BonusBall;
import domain.Lotto;
import domain.LottoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class LottoManagerTest {

    private List<Integer> lottoNumbers;

    @BeforeEach
    public void 로또넘버사전생성() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);
    }


    @ParameterizedTest
    @CsvSource(value = {"14000,14", "6500,6"})
    public void 로또구매가격으로_구입개수만들기_테스트(int purchaseAmount, int result) {
        LottoManager lottoManager = new LottoManager(purchaseAmount);
        assertThat(lottoManager.getPurchaseLottoCount(purchaseAmount)).isEqualTo(result);
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

    @Test
    public void 보너스볼생성_테스트() {
        LottoManager lottoManager = new LottoManager();
        assertThat(lottoManager.makeBonusBall(1)).isEqualTo(new BonusBall(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void 범위벗어난보너스볼_생성에러_테스트(int number) {
        LottoManager lottoManager = new LottoManager();
        assertThatThrownBy(() -> lottoManager.makeBonusBall(number)).isInstanceOf(IllegalArgumentException.class);
    }

}
