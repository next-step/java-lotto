package lotto.factory;

import lotto.generator.NumberGenerator;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.application.Constant.EXCEPTION_MESSAGE_PARSE_VALIDATION;
import static lotto.application.Constant.LOTTO_NUMBERS_SIZE;

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

    public static LottoNumbers autoCreateNumbers(NumberGenerator generator) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(autoCreateNumber(generator));
        }
        return new LottoNumbers(new ArrayList<>(lottoNumbers));
    }

    public static LottoNumbers manualCreateNumbers(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public static List<LottoNumber> manualCreateNumbers(String numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : numbers.split(", ")) {
            lottoNumbers.add(manualCreateNumber(number));
        }
        return lottoNumbers;
    }


}
