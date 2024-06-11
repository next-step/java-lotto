package common;

import lotto.LottoNumber;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StringToLottoNumberSetConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && Set.class.isAssignableFrom(targetType)) {
            String[] parts = ((String) source).split(" ");
            return Arrays.stream(parts)
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .map(LottoNumber::of)
                    .collect(Collectors.toSet());
        } else {
            throw new ArgumentConversionException("Conversion failed");
        }
    }
}