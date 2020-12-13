package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LottoTicket {
    private final List<Lotto> lottoList;

    private LottoTicket(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    private LottoTicket(LottoTicket lottoTicket, LottoTicket lottoTicket2) {
        this.lottoList = new ArrayList<Lotto>(lottoTicket.getLottoList());
        lottoList.addAll(lottoTicket2.getLottoList());
    }

    public static LottoTicket from(List<Lotto> lottoList){
        validLottoList(lottoList);
        return new LottoTicket(lottoList);
    }

    public static LottoTicket of(LottoTicket lottoTicket1, LottoTicket lottoTicket2){
        return new LottoTicket(lottoTicket1, lottoTicket2);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getLottoTicketSize(){
        return lottoList.size();
    }


    public static void validLottoList(List<Lotto> lottoList){
        if(!Optional.ofNullable(lottoList).isPresent()){
            throw new IllegalStateException("NULL일 수 없습니다.");
        }
    }
}
