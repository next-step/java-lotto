package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.LottoLengthException;
import step2.util.LottoMakeNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    @DisplayName("구입한 로또 대비 당첨된 개수")
    @ParameterizedTest
    @CsvSource(value = {"1,2,10,20,30,40:2", "1,2,3,4,5,6:6", "1,20,2,40,3,44:3"}, delimiter = ':')
    void 로또_당첨_개수(String input, int result) {
        List<LottoNumber> testNumbers = new ArrayList<>();
        testNumbers.add(LottoNumber.of(1));
        testNumbers.add(LottoNumber.of(2));
        testNumbers.add(LottoNumber.of(3));
        testNumbers.add(LottoNumber.of(4));
        testNumbers.add(LottoNumber.of(5));
        testNumbers.add(LottoNumber.of(6));

        assertThat(
                Lotto.of(testNumbers).checkWinningCount(
                        Lotto.of(
                                LottoMakeNumbers.convertStringToNumbers(input)
                        )
                )
        ).isEqualTo(result);
    }

    @DisplayName("입력한 숫자를 포함하는지 여부")
    @Test
    void 입력한_숫자_포함여부() {
        String inputNumber = "1,2,3,4,5,6";
        assertThat(Lotto.of(LottoMakeNumbers.convertStringToNumbers(inputNumber)).has(LottoNumber.of(1))).isTrue();
        assertThat(Lotto.of(LottoMakeNumbers.convertStringToNumbers(inputNumber)).has(LottoNumber.of(2))).isTrue();
        assertThat(Lotto.of(LottoMakeNumbers.convertStringToNumbers(inputNumber)).has(LottoNumber.of(3))).isTrue();
        assertThat(Lotto.of(LottoMakeNumbers.convertStringToNumbers(inputNumber)).has(LottoNumber.of(4))).isTrue();
        assertThat(Lotto.of(LottoMakeNumbers.convertStringToNumbers(inputNumber)).has(LottoNumber.of(5))).isTrue();
        assertThat(Lotto.of(LottoMakeNumbers.convertStringToNumbers(inputNumber)).has(LottoNumber.of(6))).isTrue();

        assertThat(Lotto.of(LottoMakeNumbers.convertStringToNumbers(inputNumber)).has(LottoNumber.of(8))).isFalse();
        assertThat(Lotto.of(LottoMakeNumbers.convertStringToNumbers(inputNumber)).has(LottoNumber.of(7))).isFalse();
    }

    @DisplayName("중첩된 숫자 및 6개가 아닌 개수 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,5"})
    void 중첩_6개_검사(String lottoNumbers) {
        assertThatExceptionOfType(LottoLengthException.class).isThrownBy(() -> Lotto.of(LottoMakeNumbers.convertStringToNumbers(lottoNumbers)));
    }

    @DisplayName("Lottes 더하기 테스트")
    @ParameterizedTest
    @MethodSource("providePlusLottoParameter")
    void 로또_더하기_테스트(Lottos originLotto, Lottos addLotto) {
        int originCount = originLotto.getCount() + addLotto.getCount();
        originLotto.addLottos(addLotto);
        assertThat(originLotto.getCount()).isEqualTo(originCount);
    }

    private static Stream<Arguments> providePlusLottoParameter() {
        List<Lotto> originLotto = new ArrayList<>();
        originLotto.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6")));
        originLotto.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,7")));
        originLotto.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,7,8")));
        originLotto.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,7,8,9")));
        originLotto.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,7,8,9,10")));

        List<Lotto> addLotto = new ArrayList<>();
        addLotto.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,11")));
        addLotto.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,12")));
        addLotto.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,7,13")));
        addLotto.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,7,8,14")));
        addLotto.add(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,7,8,9,15")));

        return Stream.of(
                Arguments.of(Lottos.of(originLotto), Lottos.of(addLotto))
        );
    }
}