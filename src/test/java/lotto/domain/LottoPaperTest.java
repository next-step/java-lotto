package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoPaperTest {

    @DisplayName("로또 자동 넘버 테스트")
    @Test
    public void lottoRandomNumberTest() {
        LottoPaper lottoPaper = new LottoPaper(
                new LottoNumberStragey(){
                    @Override
                    public Set<Integer> getLottoNumber() {
                        return new HashSet<>(Arrays.asList(1,2,3,4,5,6));
                    }
                }
        );

        assertThat(lottoPaper.getLottoNumber()).contains(1,2,3,4,5,6);

    }

    @DisplayName("로또 당첨 번호 개수 에외 테스트")
    @Test
    public void lottoWinningNumberExceptionTest() {
        LottoPaper lottoPaper = new LottoPaper();
        String winNumber = "0,1,2,3,4";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoPaper.setWinningNumber(winNumber))
                .withMessageMatching("숫자는 총 6개여야 합니다.");
    }

    @DisplayName("로또 당첨 번호 범위 에외 테스트")
    @Test
    public void lottoWinningNumberBoundExceptionTest() {
        LottoPaper lottoPaper = new LottoPaper();
        String winNumber = "0,1,2,3,4,5";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoPaper.setWinningNumber(winNumber))
                .withMessageMatching("숫자는 1이상 45이하여야 합니다.");
    }

    @DisplayName("로또 당첨 번호 정상 테스트")
    @Test
    public void lottoWinningNumberTest() {
        LottoPaper lottoPaper = new LottoPaper();
        String winNumber = "1,2,3,4,5,6";
        lottoPaper.setWinningNumber(winNumber);
        assertThat(lottoPaper.getLottoNumber()).contains(1,2,3,4,5,6);
    }

}