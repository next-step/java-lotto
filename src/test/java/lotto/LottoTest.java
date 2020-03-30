package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void generateLottoTest() {
        Lotto.newAutomatic().getLottoNumbers();
    }

    @Test
    @DisplayName("로또번호 생성시 이미 있는 번호 테스트")
    void isNumberExistTest() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.newChooseNumber(1), LottoNumber.newChooseNumber(2), LottoNumber.newChooseNumber(3), 
                LottoNumber.newChooseNumber(4), LottoNumber.newChooseNumber(5), LottoNumber.newChooseNumber(6)
        );
        Lotto lotto = Lotto.newManual(lottoNumbers);

        assertAll(
                () -> assertThat(lotto.isExistNumber(LottoNumber.newChooseNumber(1))).isTrue(),
                () -> assertThat(lotto.isExistNumber(LottoNumber.newChooseNumber(5))).isTrue(),
                () -> assertThat(lotto.isExistNumber(LottoNumber.newChooseNumber(8))).isFalse(),
                () -> assertThat(lotto.isExistNumber(LottoNumber.newChooseNumber(10))).isFalse()
        );
    }

    @Test
    @DisplayName("중복된 로또번호 테스트")
    void validateDuplicationNumbersTest() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.newChooseNumber(1), LottoNumber.newChooseNumber(2), LottoNumber.newChooseNumber(3),
                LottoNumber.newChooseNumber(4), LottoNumber.newChooseNumber(5), LottoNumber.newChooseNumber(5)
        );
        assertThatThrownBy(
                () -> Lotto.newManual(lottoNumbers)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
