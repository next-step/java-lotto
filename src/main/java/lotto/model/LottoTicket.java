package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> ticketNumbers;

    public LottoTicket(List<Integer> ticketNumbers){
        this.ticketNumbers = ticketNumbers;
        Set<Integer> checkedNumbers = new HashSet<>(ticketNumbers);
        if(checkedNumbers.size()!= LOTTO_SIZE){
            throw new IllegalArgumentException("로또의 번호는 6개 이어야 합니다.");
        }
    }

    public List<Integer> getTicketNumbers(){
        //return Collections.unmodifiableSet(ticketNumbers);
        return Collections.unmodifiableList(ticketNumbers);
    }
}
