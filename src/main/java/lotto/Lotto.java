package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private List<List> lottos = new ArrayList<>();
    private List<Integer> lottoNumberList;
    private List<Integer> lottoNumbers = new ArrayList<>();

    public List<Integer> createLottoNumbers(){
        for(int i = MIN_NUMBER; i <= MAX_NUMBER; i++){
            lottoNumbers.add(i);
        }

        return lottoNumbers;
    }

    public List<Integer> chooseLottoNumbers(){
        lottoNumberList = new ArrayList<>();

        Collections.shuffle(lottoNumbers);

        for(int i = 0; i < LOTTO_COUNT; i++){
            lottoNumberList.add(lottoNumbers.get(i));
        }

        return lottoNumberList;
    }

    public List<Integer> sortLottoNumbers(){
        Collections.sort(chooseLottoNumbers());
        return lottoNumberList;
    }


    public void getLottos(int count){
        for(int i = 0; i < count; i++){
            lottos.add(sortLottoNumbers());
            System.out.println(lottos.get(i));
        }
    }
}
