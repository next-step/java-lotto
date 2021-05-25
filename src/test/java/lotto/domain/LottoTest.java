package lotto.domain;

import lotto.exception.InvalidLottoGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    LottoNumberFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new LottoNumberFactoryImpl();
    }

    @Test
    public void 로또게임_생성() {
        Lotto game = Lottos.createLotto(factory, Collections.EMPTY_LIST);
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    public void 당첨번호와_로또게임이_일치하는_숫자갯수(List<Integer> lastWeekNumbers, List<Integer> myLottoNumbers, int matchCount) {
        Lotto winLotto = Lottos.createLotto(factory, lastWeekNumbers);
        Lotto myLotto = Lottos.createLotto(factory, myLottoNumbers);
        assertThat(winLotto.matchCount(myLotto)).isEqualTo(Rank.of(matchCount));
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6),Arrays.asList(1,2,3,41,42,43),3),
                Arguments.of(Arrays.asList(1,2,3,4,5,6),Arrays.asList(11,12,13,14,15,16),0),
                Arguments.of(Arrays.asList(1,2,3,4,5,6),Arrays.asList(1,2,3,4,5,6),6)
        );
    }


    @ParameterizedTest
    @DisplayName("당첨번호 갯수가 6개 이상일 때 InvalidLottoGame 에러발생")
    @MethodSource("provideWinNumbersIsNot6")
    public void 당첨번호가_6개가아닐경우(List<Integer> numbers) {
        assertThatThrownBy(()->Lottos.createLotto(factory, numbers))
                .isInstanceOf(InvalidLottoGame.class)
                .hasMessage(String.format("%s %s",InvalidLottoGame.INVALID_LOTTO_GAME,numbers.size()));
    }

    private static Stream<Arguments> provideWinNumbersIsNot6() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6,7))
        );
    }

    @Test
    public void 당첨번호_출력() {
        assertThat(Lottos.createLotto(factory, Arrays.asList(1,2,3,4,5,6)).toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(Lottos.createLotto(factory, Arrays.asList(6,5,4,3,2,1)).toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    public static class IntArrayConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            if (source instanceof String && int[].class.isAssignableFrom(targetType)) {
                String[] stringArray = ((String) source).split("\\s*,\\s*");
                int[] intArray = new int[stringArray.length];
                int idx = 0;
                for( String number : stringArray) {
                    intArray[idx++] = Integer.parseInt(number);
                }
                return intArray;
            } else {
                throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                        + targetType + " not supported.");
            }
        }

    }
}
