package secondplacelotto.model;



import java.util.ArrayList;
import java.util.List;

public class LottoTicketMachine {

    private Money money;

    public LottoTicketMachine(Money money){
        this.money = money;
    }

    public Lottos ticketedLottos(){
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < money.getBuybleLottoCount(); i++) {
            lottoList.add(new Lotto());
        }

        return new Lottos(lottoList);
    }
}
