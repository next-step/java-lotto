package lotto;

import java.util.ArrayList;
import java.util.List;

public final class LottoList {

    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoList(int purchaseCount) {
        for(int i=0; i<purchaseCount; i++){
            lottoList.add(new Lotto());
        }
    }

    public int size(){
        return lottoList.size();
    }

    @Override
    public String toString() {
        return "LottoList = " + lottoList;
    }
}
