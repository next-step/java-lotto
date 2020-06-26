package lotto;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private Set<Integer> lottoNumbers;

    public LottoTicket(Set<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            checkLottoNumber(lottoNumber);
        }
        this.lottoNumbers = lottoNumbers;
    }

    public String makeTicketForPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer lottoNumber : lottoNumbers) {
            sb.append(lottoNumber);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public int matchWinningNumber(Set<Integer> winningNumbers) {
        return lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toSet())
                .size();
    }

    public void checkLottoNumber(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Lotto numbers must be positive number.");
        }
        if (number > RandomPicker.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("Lotto numbers must be less than 46.");
        }
    }
}
