package step2.domain;

public class LottoMarket {

    private final int PRICE = 1000;
    private LottoMachine machine;
    private LottoList list;

    public LottoMarket(LottoMachine machine, LottoList list) {
        this.machine = machine;
        this.list = list;
    }

    public void buy(int money) {
        int count = money / PRICE;
        for (int i = 0; i < count; i++) {
            list.buyLotto(machine);
        }
    }
}
