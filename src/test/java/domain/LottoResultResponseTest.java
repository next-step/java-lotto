package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class LottoResultResponseTest {

    @Test
    public void test(){
//        Set set = new HashSet();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(4);
//        set.add(5);
//        set.add(6);
//
//        Set winNumbers = new HashSet();
//        winNumbers.add(1);
//        winNumbers.add(2);
//        winNumbers.add(3);
//        winNumbers.add(4);
//        winNumbers.add(5);
//        winNumbers.add(7);
//        Lotto lotto = new Lotto(set);
//        System.out.println("-----------");
//        lotto.getNumbers().removeAll(winNumbers);
//        System.out.println(lotto.getNumbers().size());


        List<Integer> LOTTO_NUMBERS =IntStream.range(1, 45)
            .boxed()
            .collect(Collectors.toList());
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> result = LOTTO_NUMBERS.stream()
            .limit(6)
            .collect(Collectors.toList());
        System.out.println(Arrays.toString(result.toArray()));
    }
}
