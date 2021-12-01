package lotto.factory;

import lotto.generator.NumberGenerator;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoWinner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.application.Constant.LOTTO_NUMBERS_SIZE;

public class LottoNumbersFactory {

    private LottoNumbersFactory() {
    }

    public static LottoNumbers create(List<LottoNumber> lottoNumbers){
        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers createByGenerator(NumberGenerator generator) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(LottoNumberFactory.createByGenerator(generator));
        }
        return new LottoNumbers(new ArrayList<>(lottoNumbers));
    }

    public static LottoNumbers createByInput(String input) {
        return new LottoNumbers(convertTo(input));
    }

    public static LottoWinner createWinner(String input, LottoNumber bonusNumber) {
        return new LottoWinner(convertTo(input), bonusNumber);
    }

    private static List<LottoNumber> convertTo(String input) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String lottoNumber : input.split(", ")) {
            lottoNumbers.add(LottoNumberFactory.createByString(lottoNumber));
        }
        return lottoNumbers;
    }
}
