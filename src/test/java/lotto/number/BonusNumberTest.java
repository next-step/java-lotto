package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("보너스 넘버는 ")
class BonusNumberTest {
    @DisplayName("LottoNumber 를 필드변수로 가진다.")
    @Test
    void bonusNumberHasLottoNumberAsFieldMember() {
        BonusNumber number = new BonusNumber(1);
        assertThat(number.value()).isEqualTo(new LottoNumber(1));
    }

    @DisplayName("1 미만 or 45 초과 일 경우 오류 출력")
    @ParameterizedTest(name = "숫자 {0} 일 때")
    @ValueSource(ints = {0, 46})
    void bonusNumberUnder1orAbove45ThrowsError(int number) {
        assertThatThrownBy(() -> new BonusNumber(number)).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("로또 숫자는 1 이상, 45 이하의 정수입니다.");
    }
}
