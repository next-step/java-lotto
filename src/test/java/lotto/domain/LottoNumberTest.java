package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumberTest {

    @DisplayName("로또 자동 넘버 테스트")
    @Test
    public void lottoRandomNumberTest() {
        LottoNumber lottoNumber = new LottoNumber(
                new LottoNumberStragey(){
                    @Override
                    public Set<Integer> getLottoNumber() {
                        return new HashSet<>(Arrays.asList(1,2,3,4,5,6));
                    }
                }
        );

        assertThat(lottoNumber.getLotto()).contains(1,2,3,4,5,6);

    }

    @DisplayName("로또 당첨 번호 개수 에외 테스트")
    @Test
    public void lottoWinningNumberExceptionTest() {
        LottoNumber lottoNumber = new LottoNumber();
        String winNumber = "0,1,2,3,4";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoNumber.setWinningNumber(winNumber))
                .withMessageMatching("숫자는 총 6개여야 합니다.");
    }

    @DisplayName("로또 당첨 번호 범위 에외 테스트")
    @Test
    public void lottoWinningNumberBoundExceptionTest() {
        LottoNumber lottoNumber = new LottoNumber();
        String winNumber = "0,1,2,3,4,5";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoNumber.setWinningNumber(winNumber))
                .withMessageMatching("숫자는 1이상 45이하여야 합니다.");
    }

    @DisplayName("로또 당첨 번호 정상 테스트")
    @Test
    public void lottoWinningNumberTest() {
        LottoNumber lottoNumber = new LottoNumber();
        String winNumber = "1,2,3,4,5,6";
        lottoNumber.setWinningNumber(winNumber);
        assertThat(lottoNumber.getLotto()).contains(1,2,3,4,5,6);
    }

}