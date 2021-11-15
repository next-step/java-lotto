package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {

    private static final LottoNumber NUM_1 = new LottoNumber(1);
    private static final LottoNumber NUM_2 = new LottoNumber(2);
    private static final LottoNumber NUM_3 = new LottoNumber(3);
    private static final LottoNumber NUM_10 = new LottoNumber(10);
    private static final LottoNumber NUM_15 = new LottoNumber(15);
    private static final LottoNumber NUM_20 = new LottoNumber(20);

    @DisplayName("LottoNumber를 정렬된 상태로 가지고 있는지")
    @Test
    void lottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers(asList(NUM_3, NUM_1, NUM_2, NUM_10, NUM_15, NUM_20));
        assertThat(lottoNumbers.lottoNumbers()).isEqualTo(asList(NUM_1, NUM_2, NUM_3, NUM_10, NUM_15, NUM_20));
    }

    @DisplayName("당첨번호개수에 맞게 등급을 잘 반환하는지")
    @ParameterizedTest(name = "[{index}] lottos: {0}, winnings: {1}, grade: {2}")
    @MethodSource("matchArguments")
    void match(LottoNumbers lottoNumbers, LottoNumbers winningNumbers, Grade expectedGrade) {
        Grade grade = lottoNumbers.rank(winningNumbers);
        assertThat(grade).isEqualTo(expectedGrade);
    }

    static Stream<Arguments> matchArguments() {
        LottoNumbers lottoNumbers = new LottoNumbers(asList(NUM_3, NUM_1, NUM_2, NUM_10, NUM_20, NUM_15));
        return Stream.of(
                Arguments.of(lottoNumbers, new LottoNumbers(asList(NUM_3, NUM_1, NUM_2, NUM_10, NUM_20, NUM_15)), Grade.FIRST),
                Arguments.of(lottoNumbers, new LottoNumbers(asList(NUM_3, NUM_1, NUM_2, num(43), num(44), num(45))), Grade.FOURTH),
                Arguments.of(lottoNumbers, new LottoNumbers(asList(num(40), num(41), num(42), num(43), num(44), num(45))), Grade.BANG)
                );
    }

    private static LottoNumber num(int num) {
        return new LottoNumber(num);
    }

    @DisplayName("중복된 로또번호를 입력할 경우 예외를 던진다.")
    @Test
    void create_duplicatedLottoNumbers() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(asList(NUM_3, NUM_3, NUM_2, NUM_10, NUM_20, NUM_15)))
                .withMessage(LottoNumbers.DUPLICATION_ERROR_MESSAGE);
    }
}
