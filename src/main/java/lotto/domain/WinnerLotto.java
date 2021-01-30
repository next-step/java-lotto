package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerLotto implements Lotto {

    private final LottoNumber BonusBall;
    private final List<LottoNumber> numbers;


    public WinnerLotto(LottoNumber bonusBall, List<LottoNumber> numbers) {
        Validator.checkSizeOfLotto(numbers);
        Validator.checkDuplicatedNumber(numbers);
        BonusBall = bonusBall;
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusBall() {
        return BonusBall;
    }

    public static List<LottoNumber> getWinnerLottoWithSplitting(String text) {
        String [] inputs = text.split(DELIMITER);
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
