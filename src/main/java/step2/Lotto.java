package step2;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lotto {

    private final Set<Integer> lotto;

    public Lotto() {
        List<Integer> lottoList = IntStream.range(1, 45).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoList);
        this.lotto = lottoList.stream()
                .limit(6)
                .collect(Collectors.toSet());
    }

    public Lotto(List<Integer> lotto){
        this.lotto = new HashSet<>(lotto);
    }

    public void printLotto(){
        System.out.println(lotto.toString());
    }

}
