package lotto;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLotto(3000);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
