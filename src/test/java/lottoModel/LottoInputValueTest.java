package lottoModel;

import lottoView.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    @DisplayName("예외 검증 테스트")
    void textConvertNumber_문자숫자변환() {

        String text = "12a3";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoInputValue.convertNum(text);
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(text));
    }

    @Test
    @DisplayName("Text 개행문 기준 split")
    void splitTextByEnter() {

        String text = "1,2,3,4,5,6\n7,8,9,10,11,12";
        LottoInputValue manualInputValue = new LottoInputValue(text);
        assertThat(manualInputValue.splitTextByEnter().length).isEqualTo(2);

    }

    @Test
    @DisplayName("수동 로또 번호 변환")
    void convertManualLottoNumbers() {
        String text = "8, 21, 23, 41, 42, 43\n" +
                "3, 5, 11, 16, 32, 38\n" +
                "7, 11, 16, 35, 36, 44";
        LottoInputValue manualInputValue = new LottoInputValue(text);
        List<Lotto> manualLottos = manualInputValue.convertManualLottoNumbers(3);
        assertThat(manualLottos.get(0)).isEqualTo(new Lotto(new ArrayList(Arrays.asList(8, 21, 23, 41, 42, 43))));
        assertThat(manualLottos.get(1)).isEqualTo(new Lotto(new ArrayList(Arrays.asList(3, 5, 11, 16, 32, 38))));
        assertThat(manualLottos.get(2)).isEqualTo(new Lotto(new ArrayList(Arrays.asList(7, 11, 16, 35, 36, 44))));

    }
}
