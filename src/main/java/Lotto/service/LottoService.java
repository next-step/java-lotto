package Lotto.service;

import Lotto.domain.Lotto;
import Lotto.domain.MyLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    public Lotto generateLottoNumbers(){
        List<Integer> lottoNumberRange = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumberRange.add(i);
        }

        Collections.shuffle(lottoNumberRange);
        List<Integer> lottoNumbers = lottoNumberRange.subList(0,6);

        return new Lotto(lottoNumbers);
    }


    public MyLotto generateMyLotto(int money) {
        int lottoCount = money/LOTTO_PRICE;
        List<Lotto> lottoList = new ArrayList<>();

        for(int i=0; i<lottoCount; i++){
            lottoList.add(generateLottoNumbers());
        }

        return new MyLotto(lottoList);
    }
}
