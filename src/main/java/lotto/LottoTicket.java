package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private List<LottoNumber> numbers;

    public LottoTicket(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (Integer number: numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        this.numbers = lottoNumbers;
    }

}
