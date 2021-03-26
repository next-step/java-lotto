package step2;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList){
        this.lottoList = lottoList;
    }

    public static Lottos of(PurchaseManager manager){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<manager.getPurchasedLottoNumber().getNumber();i++){
            lottoList.add(Lotto.generate());
        }
        return new Lottos(lottoList);
    }


    public List<Lotto> getLottos() {
        return lottoList;
    }
}
