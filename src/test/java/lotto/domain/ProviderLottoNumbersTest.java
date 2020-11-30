package lotto.domain;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProviderLottoNumbersTest {

    @Test
    public void getLottoNumber() {
        //Given & When
        Lotto lotto = ProviderLottoNumbers.getLottoNumbers(new LottoAutoMachine());

        //Then
        assertThat(lotto.sizeLottoNumber()).isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource("notValidLottoNumber")
    public void inValidLottoNumbers(Set<Integer> lottoNumbers) {
        assertThatThrownBy(() ->

                ProviderLottoNumbers.isValidLottoNumber(lottoNumbers)

        ).isInstanceOf(NotValidLottoNumberException.class)
         .hasMessage(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
    }

    private static Stream<Arguments> notValidLottoNumber() {
        return Stream.of(
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 6, 13))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 55, 60)))
        );
    }

    @ParameterizedTest
    @MethodSource("notValidBonusball")
    public void bonusballInvalidNumber(int bonusBall) {
        assertThatThrownBy(() ->

                ProviderLottoNumbers.isValidRange(bonusBall)

        ).isInstanceOf(NotValidLottoNumberException.class)
         .hasMessage(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
    }

    private static Stream<Arguments> notValidBonusball(){
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(46),
                Arguments.of(0)
        );
    }
}
