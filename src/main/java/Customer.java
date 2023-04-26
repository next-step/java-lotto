import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Money money;
    private List<Lotto> lottos = new ArrayList<>();

    public Customer(int money){
        this.money = new Money(money);
    }

    public int getMoney(){
        return this.money.getMoney();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void buyLotto(LottoGenerator lottoGenerator) {
        for(int i=0; i<money.getMoney()/lottoGenerator.getPrice(); i++) {
            lottos.add(new Lotto(lottoGenerator));
        }
    }
}
