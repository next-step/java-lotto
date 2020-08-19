package nextstep.lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private List<LottoNumber> ticket;

    private LottoTicket(List<LottoNumber> numbers) {
        this.ticket = new ArrayList<>();
        for(LottoNumber number : numbers){
            this.ticket.add(number);
        }
    }

    public static LottoTicket create(List<LottoNumber> numbers) {
        return new LottoTicket(numbers);
    }

    public int matchCount(List<LottoNumber> winnerLotto) {
        return (int) ticket.stream()
                .filter(winnerLotto::contains)
                .count();
    }

    public List<LottoNumber> getLottoNumber(){
        return ticket;
    }
}
