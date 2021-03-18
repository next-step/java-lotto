package lotto.domain;

import lotto.common.LottoConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final List<Integer> lottoNumber;

    public LottoMachine() {
        this.lottoNumber = initLottoRange();
    }

    private List<Integer> initLottoRange() {
        return IntStream.rangeClosed(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<LottoNumbers> lottoNumbers(int buyCount){

        List<LottoNumbers> buyLotto = new ArrayList<>();

        for (int i = 0; i < buyCount; i++){
            buyLotto.add(oneLottoNumbers());
        }

        return buyLotto;
    }

    private LottoNumbers oneLottoNumbers() {

        Collections.shuffle(lottoNumber);

        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < LottoConstants.LOTTO_NUMBER_COUNT; i++){
            lottoNumbers.add(lottoNumber.get(i));
        }

        return new LottoNumbers(lottoNumbers);
    }
}
