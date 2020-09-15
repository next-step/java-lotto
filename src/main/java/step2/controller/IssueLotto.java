package step2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssueLotto {

    public int create(int money) {
        return money / 1000;
    }

    public List<List<int[]>> issueLottos(int count) {
        List<List<int[]>> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            lottos.add(new IssueLotto().issueLotto());
        }
        return lottos;
    }

    public List<int[]> issueLotto() {
        List numbers = makeRandomNumber();
        return makeLottoNumber(numbers);
    }

    public List makeRandomNumber() {
        List numbers = new ArrayList();
        for(int i = 0 ; i < 45 ; i++) {
            numbers.add(i + 1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public List makeLottoNumber(List numbers) {
        List result = new ArrayList();
        for(int i = 0; i < 6; i++) {
            result.add(numbers.get(i));
        }
        Collections.sort(result);
        return result;
    }

}
