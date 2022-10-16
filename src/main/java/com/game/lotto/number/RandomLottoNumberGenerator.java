package com.game.lotto.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.game.lotto.number.SelectedLottoNumbers.LOTTO_NUMBER_SELECT_COUNT;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public SelectedLottoNumbers generateNumbers() {
        List<LottoNumber> totalNumbers = TotalLottoNumbers.getTotalNumbersOfLottoTicket();
        Collections.shuffle(totalNumbers);
        ArrayList<LottoNumber> subNumbers = new ArrayList<>(totalNumbers.subList(0, LOTTO_NUMBER_SELECT_COUNT));
        subNumbers.sort(LottoNumber::compareTo);
        return new SelectedLottoNumbers(subNumbers);
    }
}
