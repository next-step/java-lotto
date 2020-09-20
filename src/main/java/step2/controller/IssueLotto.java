package step2.controller;

import step2.domain.LottoNo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssueLotto {

    public int create(int money) {
        return money / 1000;
    }

    public List<LottoNo> issueLottos(int count) {
//        List<List<int[]>> lottos = new ArrayList<>();
        List<LottoNo> lottoNos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            lottoNos.add(new IssueLotto().issueLotto());
        }
        return lottoNos;
    }

    public LottoNo issueLotto() {
        List<Integer> numbers = makeRandomNumber();
        return makeLottoNumber(numbers);
    }

    public List<Integer> makeRandomNumber() {
        List<Integer> numbers = new ArrayList();
        for(int i = 0 ; i < 45 ; i++) {
            numbers.add(i + 1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public LottoNo makeLottoNumber(List<Integer> numbers) {
        List<Integer> result = new ArrayList();
        for(int i = 0; i < 6; i++) {
            result.add(numbers.get(i));
        }
        Collections.sort(result);
        LottoNo lottoNo = new LottoNo(result.get(0), result.get(1), result.get(2), result.get(3), result.get(4), result.get(5));
        return lottoNo;
    }

}
