package lotto.domain;

import lotto.exception.InvalidLottoGame;
import lotto.util.MessageContainer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @Test
    public void 로또게임_생성() {
        LottoGame game = new LottoGame();
        assertThat(game.isValid()).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value={"1,2,3,4,5,6:1,2,3,41,42,43:3","1,2,3,4,5,6:11,12,13,14,15,16:0","1,2,3,4,5,6:1,2,3,4,5,6:6"},delimiterString = ":")
    public void 지난주_당첨번호와_일치하는갯수(@ConvertWith(IntArrayConverter.class) int[] numbers1, @ConvertWith(IntArrayConverter.class)int[] numbers2, int matchingCount) {
        LottoGame game1 = new LottoGame(numbers1);
        LottoGame game2 = new LottoGame(numbers2);

        assertThat(game1.getRank(game2)).isEqualTo(matchingCount);
    }

    @Test
    public void 당첨번호_갯수이상() {
        assertThatThrownBy(()->new LottoGame(1,2,3,4,5,6,7))
                .isInstanceOf(InvalidLottoGame.class)
                .hasMessageContaining(MessageContainer.INVALID_LOTTO_GAME);
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
