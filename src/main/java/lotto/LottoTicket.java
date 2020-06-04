package lotto;

import java.util.List;

public class LottoTicket {
    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public String makeTicketForPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int length = lottoNumbers.size();
        for(int i = 0; i< length;i++) {
            sb.append(lottoNumbers.get(i));
            sb.append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append("]");
        return sb.toString();
    }

    public int matchWinningNumber(List<Integer> winningNumbers) {
        int matchCnt = 0;
        for(Integer number : winningNumbers) {
            checkLottoNumber(number);
            matchCnt = lottoNumbers.contains(number)? matchCnt+1 : matchCnt;
        }
        return matchCnt;
    }

    public void checkLottoNumber(Integer number) {
        if(number <= 0) {
            throw new IllegalArgumentException("Lotto numbers must be positive number.");
        }
        if(number >45) {
            throw new IllegalArgumentException("Lotto numbers must be less than 46.");
        }
    }
}
