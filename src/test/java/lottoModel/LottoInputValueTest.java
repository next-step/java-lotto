package lottoModel;

import lottoView.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoInputValueTest {

    @Test
    @DisplayName("로또 보너스 넘버 숫자 변환")
    void convertBonusNumber_로또보너스숫자변환() {
        LottoInputValue lottoValue = new LottoInputValue("1, 2, 3, 4, 5, 6");
        Set<Integer> lastLottoNumber = lottoValue.convertLastLottoNumbers();
        LottoInputValue lottoBonusNumber = new LottoInputValue("7");
        assertThat(lottoBonusNumber.convertLottoBonusNumbers(lastLottoNumber)).isEqualTo(7);
    }

    @Test
    @DisplayName("지난 주 당첨 번호")
    void convertLastLottoNumbers_지난주당첨번호벼환() {
        LottoInputValue lottoInputValue = new LottoInputValue("1, 2, 3, 4, 5, 6");
        Set<Integer> lastLotto = lottoInputValue.convertLastLottoNumbers();
        assertThat(lastLotto.size()).isEqualTo(6);
    }

    @Test
    void textConvertNumber_문자숫자변환() {

        String text = "12a3";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoInputValue.convertNum(text);
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(text));
    }
}
