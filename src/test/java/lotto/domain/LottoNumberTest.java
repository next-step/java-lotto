package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @Test
    void valid() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumber(-1)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    private static Stream<Arguments> provideLottoMatch() {
        return Stream.of(
                Arguments.of(new Lotto(LottoNumberList.createLottoNumbers(new int[]{1, 2, 3, 4, 5, 6})), 6),
                Arguments.of(new Lotto(LottoNumberList.createLottoNumbers(new int[]{2, 3, 4, 5, 6, 7})), 5),
                Arguments.of(new Lotto(LottoNumberList.createLottoNumbers(new int[]{3, 4, 5, 6, 7, 8})), 4),
                Arguments.of(new Lotto(LottoNumberList.createLottoNumbers(new int[]{4, 5, 6, 7, 8, 9})), 3),
                Arguments.of(new Lotto(LottoNumberList.createLottoNumbers(new int[]{5, 6, 7, 8, 9, 10})), 2),
                Arguments.of(new Lotto(LottoNumberList.createLottoNumbers(new int[]{6, 7, 8, 9, 10, 11})), 1),
                Arguments.of(new Lotto(LottoNumberList.createLottoNumbers(new int[]{7, 8, 9, 10, 11, 12})), 0)
        );
    }

    @ParameterizedTest(name = "로또 번호가 일치하는 갯수를 반환한다.")
    @MethodSource(value = "provideLottoMatch")
    void match(Lotto lotto, int matchCount) {
        Lotto winner = new Lotto(LottoNumberList.createLottoNumbers(new int[]{1, 2, 3, 4, 5, 6}));

        assertThat(lotto.match(winner)).isEqualTo(matchCount);
    }
}
