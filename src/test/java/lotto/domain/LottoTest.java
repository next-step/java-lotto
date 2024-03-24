package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.error.exception.SizeExceedLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {

    @Test
    @DisplayName("Lotto는 6개의 LottoNumber만 가질수 있다")
    public void Lotto_Can_Only_Have_6_Lotto_Number() {
        Lotto lotto = Lotto.fromValues(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("Lotto는 7개 이상의 LottoNumber를 가질 경우 Exception이 발생한다")
    public void If_Lotto_Has_More_Than_7_LottoNumbers_Occurs_Exception() {
        assertThatThrownBy(() -> Lotto.fromValues(Arrays.asList(1, 2, 3, 4, 5, 6
            , 7)))
            .isInstanceOf(SizeExceedLottoException.class)
            .hasMessage("로또의 사이즈는 최대 6입니다. 입력값: 7");
    }

    @Test
    @DisplayName("createAutoLottos는 구매 횟수 만큼 로또번호를 생성해야한다")
    public void Lotto_Should_Create_Auto_Lottos_For_Purchase_Count(){
        List<Lotto> autoLottos = Lotto.createAutoLottos(10);
        assertThat(autoLottos.size()).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:True", "2:True", "3:True", "10:False", "20:False", "30:False"}, delimiter = ':')
    @DisplayName("Lotto는 어떤 LottoNumber가 전달될 경우 LottoNumber가 Lotto에 포함될 경우 참을 반환한다")
    public void Lotto_Should_Return_True_If_Lotto_Contain_Given_Number(int input, boolean expected){
        Lotto lotto = Lotto.fromValues(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.fromInt(input);

        assertThat(lotto.contains(lottoNumber)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Lotto는 자신의 크기를 반환한다")
    public void Lotto_Should_Return_Self_Size(){
        Lotto lotto = Lotto.fromValues(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.size()).isEqualTo(6);
    }
}
