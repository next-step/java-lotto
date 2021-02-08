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
        if (lottoTicket.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또의 숫자는 6개입니다.");
        }
        return lottoTicket;
    }
}
