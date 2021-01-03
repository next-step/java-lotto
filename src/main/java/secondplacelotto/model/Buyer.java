package secondplacelotto.model;

public class Buyer {

    private Money money;
    private Lottos lottos;

    public Buyer(Money money){
        this.money = money;
    }

    public Lottos buyLottos(){
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine(this.money);
        this.lottos = lottoTicketMachine.ticketedLottos();

        return lottos;
    }

    public void matchLottos(WinningNumbers winningNumbers){
        winningNumbers.match(lottos);
    }
}
