package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.exception.LottoCountBoundException;
import step4.exception.ValidEmptyException;
import step4.exception.ValidNullException;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LastWeekLottoGeneratorTest {

    @DisplayName("지난주 로또 번호가 잘 생성되는지 확인합니다.")
    @ParameterizedTest
    @MethodSource("createStringLotto")
    void createLastWeekLotto(String input, Lotto expected) {
        assertThat(LastWeekLottoGenerator.separateLottoToList(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> createStringLotto() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.of("11,12,13,14,15,16", new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16))),
                Arguments.of("21,22,23,24,25,26", new Lotto(Arrays.asList(21, 22, 23, 24, 25, 26)))
        );
    }

    @Test
    @DisplayName("로또 번호가 5개 이하일 경우 익셉션이 발생합니다.")
    void throwLottoCount5() {
        assertThatThrownBy(() -> LastWeekLottoGenerator.separateLottoToList("1,2,3,4,5"))
                .isInstanceOf(LottoCountBoundException.class);
    }

    @Test
    @DisplayName("로또 번호가 5개 이하일 경우 익셉션이 발생합니다.")
    void throwLottoCount7() {
        assertThatThrownBy(() -> LastWeekLottoGenerator.separateLottoToList("1,2,3,4,5,6,7"))
                .isInstanceOf(LottoCountBoundException.class);
    }

    @Test
    @DisplayName("로또 번호가 널일경우 익셉션이 발생합니다.")
    void throwLottoNull() {
        assertThatThrownBy(() -> LastWeekLottoGenerator.separateLottoToList(null))
                .isInstanceOf(ValidNullException.class);
    }
    @Test
    @DisplayName("로또 번호가 5개 이하일 경우 익셉션이 발생합니다.")
    void throwLottoEmpty() {
        assertThatThrownBy(() -> LastWeekLottoGenerator.separateLottoToList(" "))
                .isInstanceOf(ValidEmptyException.class);
    }


}