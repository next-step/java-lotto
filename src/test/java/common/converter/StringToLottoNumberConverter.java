package common.converter;

import lotto.LottoNumber;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToLottoNumberConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String) {
            int number = Integer.parseInt(((String) source));
            return LottoNumber.of(number);
        } else {
            throw new ArgumentConversionException("Conversion failed");
        }
    }
}