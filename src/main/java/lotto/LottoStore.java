package lotto;

import java.util.*;
import static lotto.LottoConstant.*;

public class LottoStore {

    private List<LottoNumber> lottoNumberList;

    public LottoStore() {
        lottoNumberList = new ArrayList<>();
        for(int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
    }

    public List<LottoTicket> buyLotto(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 구입할 금액이 부족합니다.");
        }
        return generateLottoTickets(money / LOTTO_PRICE);
    }

    private List<LottoTicket> generateLottoTickets(int count) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    private LottoTicket generateLottoTicket(){
        Set<LottoNumber> lottoNumbers = new TreeSet<>( Comparator.comparingInt(LottoNumber::getNumber));
        Collections.shuffle(lottoNumberList);
        for(int i = 0; i < LOTTO_TICKET_SIZE; i++) {
            lottoNumbers.add(lottoNumberList.get(i));
        }

        return new LottoTicket(lottoNumbers);
    }

}
