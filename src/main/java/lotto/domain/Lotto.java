package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.Validator;

public interface Lotto {

    int LOTTO_NUMBER_SIZE = 6;
    String DELIMITER = "[ ,]+";

    static List<LottoNumber> getLottoNumberListWithSplitting(String lottoNumbersInput) {
        String[] inputs = lottoNumbersInput.split(DELIMITER);
        List<LottoNumber> lottoTicket = new ArrayList<>();
        for (String input : inputs) {
            Validator.isInteger(input);
            Validator.isNegative(input);
            lottoTicket.add(new LottoNumber(Integer.parseInt(input)));
        }
        Validator.checkSizeOfLotto(lottoTicket);
        return lottoTicket;
    }
}
