package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoNumber.getLottoNumbers;

public class LottoTicket {
    private static final String LOTTO_TICKET_NULLPOINT_EXCEPTION = "로또가 생성 되지 않았습니다.";

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

    public int lottoNumberMatchCount(WinningNumbers winningNumbers){
        return (int) lottoTicket.stream()
                .filter(i -> winningNumbers.getWinningNumbers().contains(i))
                .count();
    }

    public List<Integer> getTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }
}
