package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Lotto.SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@Nested
@DisplayName("Lotto 클래스는")
public class LottoTest {
    private static Stream<Arguments> generateArgumentsStream() {
        List<Arguments> listOfArguments = new LinkedList<>();
        listOfArguments.add(Arguments.of(WinningLotto.ofString("1,2,3,4,5,6"), 6));
        listOfArguments.add(Arguments.of(WinningLotto.ofString("1,2,13,14,15,6"), 3));
        listOfArguments.add(Arguments.of(WinningLotto.ofString("12,13,14,5,6,7"), 2));
        listOfArguments.add(Arguments.of(WinningLotto.ofString("1,2,3,4,8,9"), 4));
        listOfArguments.add(Arguments.of(WinningLotto.ofString("1,2,4,7,6,3"), 5));
        listOfArguments.add(Arguments.of(WinningLotto.ofString("11,12,13,14,15,6"), 1));
        listOfArguments.add(Arguments.of(WinningLotto.ofString("14,15,25,35,45,33"), 0));
        return listOfArguments.stream();
    }

    @ParameterizedTest
    @MethodSource("generateArgumentsStream")
    @DisplayName("lotto 번호 matching 테스트")
    void checkMatchingTest(WinningLotto winningLotto, int expect) {
        Lotto lotto = Lotto.ofManualStringLottoNumbers("1,2,3,4,5,6");
        assertThat(lotto.countMatching(winningLotto)).isEqualTo(expect);
    }

    @Nested
    @DisplayName("checkSize 메소드는")
    class Describe_checkSize {
        @Nested
        @DisplayName("입력된 로또의 길이가 SIZE 보다 클 때")
        class Long_lotto_size_test {
            @Test
            @DisplayName(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다. 를 반환")
            void long_lotto_size_test() {
                assertThatThrownBy(() -> {
                    Lotto lotto = Lotto.ofManualStringLottoNumbers("1,2,3,4,5,6,7");
                }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
            }
        }

        @Nested
        @DisplayName("입력된 로또의 길이가 SIZE 보다 작을 때")
        class Short_lotto_size_test {
            @Test
            @DisplayName(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.")
            void short_lotto_size_test() {
                assertThatThrownBy(() -> {
                    Lotto lotto = Lotto.ofManualStringLottoNumbers("1,2,3,5");
                }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
            }
        }
    }

    @Nested
    @DisplayName("checkDistinct 메소드는 입력된 lotto 에 중복된 숫자가 있을 때")
    class Check_distinct_lotto {
        @Test
        @DisplayName("로또에 중복된 숫자가 존재합니다. 를 반환")
        void distinctCheckTest() {
            assertThatThrownBy(() -> {
                Lotto lotto = Lotto.ofManualStringLottoNumbers("1,1,1,1,1,1");
            }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("로또에 중복된 숫자가 존재합니다.");
        }
    }
}

