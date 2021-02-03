package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.Validator;

public interface Lotto {

    int LOTTO_NUMBER_SIZE = 6;
    String DELIMITER = "[ ,]+";

    default List<LottoNumber> getWinnerLottoWithSplitting(String winnerLottoInput) {
        String[] inputs = winnerLottoInput.split(DELIMITER);
        List<LottoNumber> winnerLotto = new ArrayList<>();
        for (String input : inputs) {
            Validator.isInteger(input);
            Validator.isNegative(input);
            winnerLotto.add(new LottoNumber(Integer.parseInt(input)));
        }
        if (winnerLotto.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또의 숫자는 6개입니다.");
        }
        return winnerLotto;
    }
}
