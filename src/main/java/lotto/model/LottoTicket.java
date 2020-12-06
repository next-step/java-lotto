package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> ticketNumbers;

    public LottoTicket(List<Integer> ticketNumbers){
        this.ticketNumbers = ticketNumbers;
        Set<Integer> checkedNumbers = new HashSet<>(ticketNumbers);
        if(checkedNumbers.size()!= LOTTO_SIZE){
            throw new IllegalArgumentException("로또의 번호는 6개 이어야 합니다.");
        }
    }

    public static LottoTicket of(String manualNumbers){
        List<Integer> manualLottos;
        List<String> strNumbers = Arrays.asList(Arrays.stream(manualNumbers.split(",")).map(String::trim).toArray(String[]::new));
        manualLottos = strNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());

       if(manualLottos.stream().anyMatch(i -> (i > LOTTO_MAX_NUMBER || i < LOTTO_MIN_NUMBER))){
           throw new IllegalArgumentException("로또 번호는 1~45 사이 입니다.");
       }
        return new LottoTicket(manualLottos);
    }

    public List<Integer> getTicketNumbers(){
        return Collections.unmodifiableList(ticketNumbers);
    }
}
