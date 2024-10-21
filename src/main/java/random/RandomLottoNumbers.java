package random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumbers implements LottoGenerator {
    @Override
    public List<Integer> executeStrategy() {
        List<Integer> lottoList = new ArrayList<>();
        for ( int i = 1; i <=45; i++) {
            lottoList.add(i);
        }
        Collections.shuffle(lottoList);
        lottoList = lottoList.subList(0,6);
        Collections.sort(lottoList);
        return lottoList;
    }
}
