package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("Lotto 생성에 필요한 숫자들의 전달 테스트")
class ManualLottoRequestTest {

    @DisplayName("객체 생성")
    @Test
    void createObjectWithValidParamsTest() {
        // given
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when & then
        assertThat(ManualLottoRequest.from(validNumbers)).isNotNull();
    }

    @DisplayName("잘못된 파라미터 전달 후 객체 생성")
    @ParameterizedTest
    @NullAndEmptySource
    void createObjectWithInvalidParamsTest(List<Integer> invalidNumbers) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> ManualLottoRequest.from(invalidNumbers)
        );
    }

    @DisplayName("로또 객체 생성 전달 반환 확인")
    @Test
    void toLottoTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        Lotto actual = ManualLottoRequest.from(numbers).toLotto();
        // then
        assertThat(actual).isEqualTo(new Lotto(new LottoNumbers(numbers)));
    }
}
