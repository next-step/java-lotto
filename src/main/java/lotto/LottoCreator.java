package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCreator {
    LottoNumbers numbers = new LottoNumbers();

    private static final int LOTTO_COUNT = 6;


    public void buyLottos(int num,List<Integer> lottoNumbers){
        Lottos lottos = new Lottos(num,lottoNumbers);

    };


//    public List<Integer> chooseLottoNumbers() {
//        Collections.shuffle(lottoNumbers);
//        Lotto.lottoNumber(lottoNumbers);
//        return lottoNumberList;
//    }

//    public List<Integer> sortLottoNumbers() {
//        Collections.sort(chooseLottoNumbers());
//        return lottoNumberList;
//    }
}
