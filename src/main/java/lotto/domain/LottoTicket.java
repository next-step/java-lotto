package lotto.domain;

import lotto.strategy.LottoMakeStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int LOTTO_NUMBER_FIX_SIZE = 6;
    private static final String LOTTO_TICKET_NULLPOINT_EXCEPTION = "로또가 생성 되지 않았습니다.";
    private final List<LottoNumber> lottoTicket;

    public LottoTicket(){
        this(new ArrayList<>());
    }

    public LottoTicket(LottoMakeStrategy lottoMakeStrategy){
        this.lottoTicket = lottoMakeStrategy.valueOf();
    }

    public LottoTicket(List<Integer> numbers){
        validationNullCheck(numbers);
        validationLottoTicketSizeCheck(numbers);
        this.lottoTicket = valueOf(numbers);
    }

    public static List<LottoNumber> valueOf(List<Integer> numbers){
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public Reward lottoNumberMatch(WinningNumbers winningNumbers){
        return winningNumbers.winningLottoMatch(lottoTicket);
    }

    public void validationLottoTicketSizeCheck(List<Integer> numbers){
        if(numbers.size() != LOTTO_NUMBER_FIX_SIZE){
            throw new IllegalArgumentException("로또 개수가 맞지않습니다");
        }
    }

    private void validationNullCheck (List<Integer> lottoTicket){
        if(lottoTicket.isEmpty()){
            throw new NullPointerException(LOTTO_TICKET_NULLPOINT_EXCEPTION);
        }
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }

    public List<LottoNumber> getLottoTicket() {
        return lottoTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket);
    }
}
