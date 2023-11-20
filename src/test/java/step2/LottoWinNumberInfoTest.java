package step2;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.Lotto;
import step2.lotto.domain.LottoWinNumberInfo;
import step2.lotto.utility.NumberSplitter;

class LottoWinNumberInfoTest {

    @Test
    @DisplayName("입력한 우승로또 번호를 바탕으로 우승 로또정보 객체를 만들 수 있다.")
    void createWinLottoTest() {
        String inputNumbers = "1, 2, 3, 4, 5, 6";
        Lotto winLotto = new LottoWinNumberInfo(
            NumberSplitter.splitNumber(inputNumbers)).getWinLotto();

        assertThat(winLotto.getLottoNumbers()).contains(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("우승 로또를 생성 할 때, 중복된 숫자를 입력할 수 없다.")
    void winLottoDuplicateTest() {
        String inputNumbers = "1, 2, 3, 4, 5, 5";

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoWinNumberInfo(
            NumberSplitter.splitNumber(inputNumbers)));
    }

    @Test
    @DisplayName("우승 로또를 생성 할 때, 입력한 번호는 1 ~ 45 사이의 숫자여야 한다.")
    void winLottoNumberRangeTest() {
        String inputNumbers = "1, 2, 3, 4, 5, 46";

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoWinNumberInfo(
            NumberSplitter.splitNumber(inputNumbers)));
    }

    @Test
    @DisplayName("우승번호와 비교하여 일치하는 번호의 갯수를 반환한다.")
    void matchCountTest() {
        LottoWinNumberInfo lottoWinNumberInfo = new LottoWinNumberInfo(Set.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Set.of(1,2,3,4,5,6));

        assertThat(lottoWinNumberInfo.matchCount(lotto)).isEqualTo(6);
    }

}
