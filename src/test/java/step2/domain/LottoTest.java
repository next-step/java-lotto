package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {
    // 생성시 랜덤으로 1~45 숫자가 중복되지 않게 6개를 갖는 숫자 리스트를 갖고 있다.

    static Stream<Arguments> numberLists() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5, 100)),
                arguments(Arrays.asList(-1, 2, 3, 4, 5, 6)),
                arguments(Arrays.asList(1, 2, 3, 47, 5, 6)),
                arguments(Arrays.asList(1, 2, 3, 0, 5, 6))
        );
    }

    @DisplayName("숫자 리스트를 받아 Lotto 생성하기. 출력")
    @Test
    void createLottoTest() {
        List list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(list);

        assertThat(lotto.toString()).isEqualTo(list.toString());
    }

    @DisplayName("로또 길이(6)가 맞지 않으면 에러발생")
    @Test
    void checkNumbersLength() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Lotto.from(Arrays.asList(1, 2, 3))
        ).withMessageContaining("로또 길이는 6개");
    }

    @DisplayName("받은 6자리 숫자중 중복된 수가 있으면 에러 발생")
    @Test
    void haveUniqueNumbers() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Lotto.from(Arrays.asList(1, 1, 2, 3, 4, 5))
        ).withMessageContaining("중복");
    }

    @DisplayName("로또 숫자는 1~45 사이 숫자만 존재한다.")
    @ParameterizedTest
    @MethodSource("numberLists")
    void isBoundary_in_1to45(List<Integer> list) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Lotto.from(list)
        ).withMessageContaining("유효하지 않");
    }

    @DisplayName("로또 출력시 숫자는 오름차순으로 나온다.")
    @Test
    void showNumbersASC() {
        Lotto lotto = Lotto.from(Arrays.asList(9, 5, 4, 3, 8, 1));
        assertThat(lotto.getNumbers()).containsExactly(1, 3, 4, 5, 8, 9);
    }

    @DisplayName("로또 내부 리스트 방어적 복사")
    @Test
    void addNumberToNumberList() {
        List<Lotto> list = new ArrayList<>();
        list.add(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        list.add(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        list.add(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));

        list.stream().forEach(vo -> vo.getNumbers().add(7));
        list.stream().forEach(vo -> vo.getNumbers().add(8));
        list.stream().forEach(vo -> vo.getNumbers().add(9));

        assertThat(list.get(0).getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(list.get(0).getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(list.get(0).getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}