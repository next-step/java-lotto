package lotto;

public class LottoBuy {
    public Lottos buyLotto(int buyPay) {
        Lottos lottos = new Lottos();
        for(int count = 0; count < buyPay / 1000; count++){
            lottos.createRandomLotto();
        }
        return lottos;
    }
}
