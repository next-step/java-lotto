package lotto.domain;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;

import static lotto.domain.LottoNumber.getLottoNumbers;

public class LottoTicket {
    private static final String LOTTO_TICKET_NULLPOINT_EXCEPTION = "로또가 생성 되지 않았습니다.";
    private static final int BONUS_MATCH_COUNT = 4;

    private final List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket){
        validationNullCheck(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    private void validationNullCheck (List<Integer> lottoTicket){
        if(lottoTicket.isEmpty()){
            throw new NullPointerException(LOTTO_TICKET_NULLPOINT_EXCEPTION);
        }
    }

    public static LottoTicket valueOf(){
        return new LottoTicket(getLottoNumbers());
    }

    public boolean bonusNumberMatch(WinningNumbers winningNumbers){
        int count = lottoNumberMatchCount(winningNumbers);
        if(count == BONUS_MATCH_COUNT){
            lottoTicket.contains(winningNumbers.getBonusNumber());
            return true;
        }
        return false;
    }

    public int lottoNumberMatchCount(WinningNumbers winningNumbers){
        return  (int)lottoTicket.stream()
                .filter(i -> winningNumbers.getWinningNumbers().contains(i))
                .count();
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }
}
