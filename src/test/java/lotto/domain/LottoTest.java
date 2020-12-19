package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class LottoTest {

    @Test
    @DisplayName("수동으로 로또번호를 주었을 때 제대로 생성되었는지 테스트")
    public void createNewManualLotto() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 43, 44, 45);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        numbers.stream().forEach(number -> {
            assertThat(lotto.getLottoNumbers().containsLottoNumber(new LottoNumber(number))).isTrue();
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("수동으로 범위 밖의 로또번호를 주었을 때 오류가 발생하는지 테스트")
    public void createNewManualLotto(int input) {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 43, 44, input);

        // when
        Throwable throwable = catchThrowable(() -> {
                new Lotto(numbers);
        });

        // then
        assertThat(throwable).isInstanceOf(Exception.class)
                            .hasMessageContaining("1 ~ 45");
    }
}
