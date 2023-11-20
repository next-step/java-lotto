package lottoModel;

import lottoView.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoInputValueTest {

    @Test
    @DisplayName("로또 보너스 넘버 숫자 변환")
    void convertBonusNumber_로또보너스숫자변환() {

        LottoInputValue lottoBonusNumber = new LottoInputValue("4");
        assertThat(lottoBonusNumber.convertLottoBonusNumbers()).isEqualTo(4);

    }

    @Test
    @DisplayName("지난 주 당첨 번호")
    void convertLastLottoNumbers_지난주당첨번호벼환() {

        LottoInputValue lottoInputValue = new LottoInputValue("1, 2, 3, 4, 5, 6");
        Set<Integer> lastLotto = lottoInputValue.convertLastLottoNumbers();
        assertThat(lastLotto.size()).isEqualTo(6);
    }
}
