package lotto.factory;

import lotto.generator.NumberGenerator;
import lotto.model.LottoNumber;

import static lotto.application.Constant.EXCEPTION_MESSAGE_PARSE_VALIDATION;

public class LottoNumberFactory {

    private LottoNumberFactory() {
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber from(NumberGenerator generator) {
        return from(generator.generate());
    }

    public static LottoNumber from(String number) {
        try {
            return from(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PARSE_VALIDATION);
        }
    }


}
