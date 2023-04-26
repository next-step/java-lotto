package step2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class YourLottoTicket extends LottoTicket {
    private static final String DELIMITER = ",";

    public YourLottoTicket(String yourNumber) {
        sixNumbers = parseLottoNumbers(yourNumber);
        validate(sixNumbers);
    }

    private void validate(List<Integer> sixNumbers) {
        if (sixNumbers.size() != LOTTO_MAX_INDEX) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private List<Integer> parseLottoNumbers(String yourNumber) {
        Set<Integer> lottoNumbers = new HashSet<>();
        for (String token : yourNumber.split(DELIMITER)) {
            lottoNumbers.add(Integer.parseInt(token.trim()));
        }
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return sixNumbers.toString();
    }
}
