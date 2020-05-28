package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

    @DisplayName("로또 DATA 객체가 제대로 생성되는 지 확인")
    @Test
    public void createLottoNumberTest() {
        List<Integer> lottoNumber = createLottoNumber(1,45, 6 );
        Lotto lotto = new Lotto(lottoNumber);
        List<Integer> lottoNumberActual = lotto.getNumbers();
        assertAll(
                () -> assertThat(lotto).isNotNull(),
                () -> {
                    for(int i = 0 ; i <  lottoNumberActual.size() ; i++) {
                        assertEquals(lottoNumberActual.get(i), lottoNumber.get(i));
                    }
                }
        );
    }

    @DisplayName("로또는 6개의 수가 아닐 경우 IllegalArgument 오류가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {5, 7})
    public void validateSixNumberTest(int count) {
        assertThatThrownBy(() -> {
            new Lotto(createLottoNumber(1, 45, count));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또는 1~45 이외의 숫자로 생성할 경우 IllegalArgument 오류가 발생한다")
    @ParameterizedTest
    @MethodSource("lottoNumbersOutOfRange")
    public void validateNumberRangeTest(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 생성 시 중복된 숫자가 들어갈 경우 IllegalArgument 오류가 발생한다. ")
    @Test
    public void validateDuplicateNumberTest() {
        List<Integer> lottoNumbers = List.of(1,2,3,4,4,6);
        assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또에 전달된 숫자들 중 몇개가 포함되어 있는 지 리턴한다.")
    @Test
    public void getContainCountTest() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        int counts = lotto.getContainCount(List.of(1,2,3));

        assertThat(counts).isEqualTo(3);
    }

    @DisplayName("String 문자열을 받아 정상적으로 Lotto 가 리턴된다.")
    @Test
    public void valueOfTest() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto actualLotto = Lotto.valueOf("1, 2, 3, 4, 5, 6");

        assertThat(actualLotto).isEqualTo(lotto);
    }

    private static Stream<Arguments> lottoNumbersOutOfRange() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,0),
                        List.of(1,2,50,5,40,4),
                        List.of(46,47,48,49,50,51)));
    }

    private List<Integer> createLottoNumber(final int startInclusive, final int endInclusive, final int count) {
        List<Integer> lottoNumbers = IntStream.rangeClosed(startInclusive, endInclusive).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream().limit(count).collect(Collectors.toList());
    }

}
