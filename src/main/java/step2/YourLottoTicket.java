package step2;

import java.util.List;

public class YourLottoTicket extends LottoTicket {

    public YourLottoTicket(String yourNumber, Parser parser) {
        sixNumbers = parser.parseLottoNumbers(yourNumber);
        validate(sixNumbers);
    }

    private void validate(List<Integer> sixNumbers) {
        if (sixNumbers.size() != LOTTO_MAX_INDEX) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return sixNumbers.toString();
    }
}
