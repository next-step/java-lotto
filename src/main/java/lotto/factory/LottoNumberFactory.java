package lotto.factory;

import lotto.generator.NumberGenerator;
import lotto.model.LottoNumber;

import static lotto.application.Constant.EXCEPTION_MESSAGE_PARSE_VALIDATION;

public class LottoNumberFactory {

    private LottoNumberFactory() {
    }

    public static LottoNumber createByNumber(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber createByGenerator(NumberGenerator generator) {
        return createByNumber(generator.generate());
    }

    public static LottoNumber createByString(String number) {
        try {
            return createByNumber(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PARSE_VALIDATION);
        }
    }


}
