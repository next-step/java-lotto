package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoNumbers = new ArrayList<>();

    LottoTicket() {
        List<Integer> numbers = new LottoNumberGenerator().generateLottoNumbers();
        Collections.shuffle(numbers);

        for(int i = 0; i < 6; i++) {
            lottoNumbers.add(numbers.get(i));
        }

        Collections.sort(lottoNumbers);
    }

    // 테스트용 생성자
    public LottoTicket(String lottoTicketString) {
        String[] split = lottoTicketString.replaceAll("\\[|]", "").split(",");

        for (String s : split) {
            lottoNumbers.add(Integer.valueOf(s.trim()));
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getMatchCount(LottoWinNumber lottoWinNumber) {
        return lottoWinNumber.countMatchingNumbers(lottoNumbers);
    }
}
