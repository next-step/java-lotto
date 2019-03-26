package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class StringParseUtils {

    public static LottoTicket parseToIntegerList(String inputNumber) {
        List<LottoNumber> winingNumbers = new ArrayList<>();
        String[] split = inputNumber.trim().split(",");
        for (String str : split) {
            winingNumbers.add(LottoNumber.getBasicNumber(Integer.parseInt(str.trim())));
        }

        return new LottoTicket(winingNumbers);
    }
}
