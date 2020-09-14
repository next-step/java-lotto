package step2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssueLotto {

    public static int create(int money) {
        return money/1000;
    }

    public static List<int[]> issueLotto() {
        List<int[]> numbers = makeRandomNumber();
        return makeLottoNumber(numbers);
    }

    public static List makeRandomNumber() {
        List numbers = new ArrayList();
        for(int i = 0 ; i < 45 ; i++) {
            numbers.add(i + 1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public static List makeLottoNumber(List numbers) {
        List result = new ArrayList();
        for(int i = 0; i < 6; i++) {
            result.add(numbers.get(i));
        }
        Collections.sort(result);
        return result;
    }

    public static List<List> issueLottos(int count) {
        List<List> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            lottos.add(issueLotto());
        }
        return lottos;
    }
}
