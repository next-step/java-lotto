package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class StringParseUtils {

    public static LottoTicket parseToIntegerList(String inputNumber) {
        List<LottoNumber> winingNumbers = getLottoNumbers(inputNumber);

        return new LottoTicket(winingNumbers);
    }

    private static List<LottoNumber> getLottoNumbers(String inputNumber) {
        List<LottoNumber> winingNumbers = new ArrayList<>();
        String[] split = inputNumber.trim().split(",");
        for (String str : split) {
            winingNumbers.add(LottoNumber.getBasicNumber(Integer.parseInt(str.trim())));
        }
        return winingNumbers;
    }

    public static List<LottoTicket> parseToIntegerList3(String[] inputManualNumbers) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (String oneLineIsTicket : inputManualNumbers) {
            List<LottoNumber> parseToNewInputNumbers = getLottoNumbers(oneLineIsTicket);
            lottoTickets.add(new LottoTicket(parseToNewInputNumbers));
        }
        return lottoTickets;
    }

}
