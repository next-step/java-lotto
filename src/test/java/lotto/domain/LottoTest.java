package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    @DisplayName("당첨번호와 일치 갯수를 판별할 수 있다")
    void matched_test() {
        List<Integer> winNo = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto1 = List.of(1, 2, 3, 10, 20, 30);
        List<Integer> lotto2 = List.of(1, 2, 3, 4, 20, 30);
        List<Integer> lotto3 = List.of(10, 20, 30, 40, 12, 13);

        assertThat(new Lotto(lotto1).getMatchingCount(winNo)).isEqualTo(3);
        assertThat(new Lotto(lotto2).getMatchingCount(winNo)).isEqualTo(4);
        assertThat(new Lotto(lotto3).getMatchingCount(winNo)).isEqualTo(0);
    }

    @Test
    @DisplayName("로또 번호의 갯수가 6개인지 검증한다")
    void size_test() {
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 6);
        assertThat(new Lotto(lotto1).validateSize(lotto1)).isEqualTo(lotto1);
    }

    @DisplayName("로또 번호의 갯수가 6개가 아니면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("generateData")
    void size_exception_test(List<Integer> lottoNumbers) {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers).validateSize(lottoNumbers));
    }

    static Stream<Arguments> generateData() {
        List<Integer> numberList = new ArrayList<>(List.of(1, 2, 3, 10, 20, 30, 40, 50, 60));
        return Stream.of(
                Arguments.of(numberList)
        );
    }
}
