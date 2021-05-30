package lotto.domain;

import lotto.exception.InvalidLottoGame;
import lotto.exception.InvalidLottoNumber;
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
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    LottoNumberFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new LottoNumberFactoryImpl(new RandomStrategy());
    }

    @Test
    public void 로또게임_생성() {
        new Lotto(factory);
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    public void 당첨번호와_로또게임이_일치하는_숫자갯수(List<Integer> lastWeekNumbers, List<Integer> myLottoNumbers, int matchCount) {
        LottoNumberFactory lastWeekFactory = new LottoNumberFactoryImpl(CustomStrategy.of(lastWeekNumbers));
        LottoNumberFactory  myLottoFactory = new LottoNumberFactoryImpl(CustomStrategy.of(myLottoNumbers));
        Lotto winLotto = new Lotto(lastWeekFactory);
        Lotto myLotto = new Lotto(myLottoFactory);
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
        factory.setGenerateStrategy(CustomStrategy.of(numbers));
        assertThatThrownBy(()->new Lotto(factory))
                .isInstanceOf(InvalidLottoNumber.class)
                .hasMessage(new InvalidLottoNumber(numbers.toString()).getMessage());
    }

    private static Stream<Arguments> provideWinNumbersIsNot6() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5))
        );
    }

    @ParameterizedTest
    @MethodSource("provideWinLottoNumbers")
    public void 당첨번호_출력(List<Integer> winLottoNumbers, String expectedAsnwer) {
        factory.setGenerateStrategy(new CustomStrategy(winLottoNumbers));
        assertThat(new Lotto(factory).toString())
                .isEqualTo(expectedAsnwer);
    }
    private static Stream<Arguments> provideWinLottoNumbers()  {
        return Stream.of(Arguments.of(Arrays.asList(1,2,3,4,5,6), "[1, 2, 3, 4, 5, 6]"),
                Arguments.of(Arrays.asList(6,5,4,3,2,1) , "[1, 2, 3, 4, 5, 6]")
        );
    }
}
