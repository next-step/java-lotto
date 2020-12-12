package step2;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.Lotto;
import step2.domain.LottoNo;
import step2.domain.WinningLottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("Lotto를 생성하여 1~45 중 6개의 숫자를 중복없이 정렬하여 리턴한다.")
    void createLotto() {
        Lotto lotto = new Lotto();
        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName(value = "값을 입력하면 수동, 입력하지 않으면 자등으로 로또를 생성한다.")
    void notAutoLotto_AutoLotto() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = Lotto.create(list);
        assertThat(lotto.isAuto()).isFalse();

        for (LottoNo number : lotto.getNumbers()) {
            assertThat(list.contains(number.getNumber()));
        }

        assertThat(new Lotto().isAuto()).isTrue();
    }

    @ParameterizedTest
    @MethodSource("isNotMatchLottoNumbers_ShouldIllegalArgumentException")
    @DisplayName(value = "잘못된 숫자 리스트를 입력하면 IllegalArgumentException 발생")
    void numberValid_IllegalArgumentException(List<Integer> numbers) {
        assertThatThrownBy(() -> Lotto.create(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> isNotMatchLottoNumbers_ShouldIllegalArgumentException() {
        return Stream.of(
                Arguments.of(Lists.newArrayList(1,2,3,4,5,46)),
                Arguments.of(Lists.newArrayList(0,2,3,4,5,45)),
                Arguments.of(Lists.newArrayList(1,2,3,4,5))
        );
    }

    @Test
    @DisplayName(value = "번호 입력 시 중복된 숫자를 입력하면 IllegalArgumentException 발생")
    void isSameNumber() {
        assertThatThrownBy(() -> Lotto.create(Arrays.asList(1,2,2,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
