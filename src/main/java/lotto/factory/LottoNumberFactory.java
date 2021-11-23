package lotto.factory;

import lotto.generator.NumberGenerator;
import lotto.model.LottoNumber;

import static lotto.application.Constant.EXCEPTION_MESSAGE_PARSE_VALIDATION;

public class LottoNumberFactory {

    private LottoNumberFactory() {
    }

    public static LottoNumber autoCreateNumber(NumberGenerator generator) {
        return new LottoNumber(generator);
    }

    public static LottoNumber manualCreateNumber(int number) {
        return new LottoNumber(number);
    }

    public static LottoNumber manualCreateNumber(String number) {
        try {
            return manualCreateNumber(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PARSE_VALIDATION);
        }
    }


}
