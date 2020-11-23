package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumberTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        this.lotto = new Lotto(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,5,6,7")
    @DisplayName("로또 당첨번호 6개 이상 입력시 IllegalArgumentException 발생")
    void sameNumberOfCount_overSizeLottoNumber_throwException(String winningNumber) {
        assertThatThrownBy(() ->
                new LottoWinningNumber(lotto.getLottoNumbers()).sameNumberOfCount(winningNumber)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 숫자 6개를 입력해야 합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,7,8")
    @DisplayName("로또 번호 = 당첨번호 일치건수 확인 ")
    void sameNumberOfCount_winningNumber_isEqualTo(String winningNumber) {
        //given
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

        //when
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoNumbers);
        int sameNumberOfCount = lottoWinningNumber.sameNumberOfCount(winningNumber);

        //then
        assertThat(sameNumberOfCount).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:4:true",
            "1,2,3,4,5,9:10:false"
    }, delimiter = ':')

    @DisplayName("로또번호 보너스 번호 존재여부 확인")
    void isMatchUpToBonusNumber_isEqualTo(String winningNumber,int bonusNumber,boolean result) {
        //given
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

        //when
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoNumbers);
        boolean isFoundBonusNumber = lottoWinningNumber.isMatchUpToBonusNumber(bonusNumber);

        //then
        assertThat(isFoundBonusNumber).isEqualTo(result);
    }
}
