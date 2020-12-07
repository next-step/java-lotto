package autolotto.model;

public class Buyer {

    private final int money;
    private Lottos lottos;

    public Buyer(int money){
        this.money = money;
    }

    public void buyLottos(){
        lottos = new Lottos(money);
    }

    public Lottos getLottos(){
        return lottos;
    }
}
