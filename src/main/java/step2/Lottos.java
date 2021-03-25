package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList){
        this.lottoList = lottoList;
    }

    public static Lottos autoLotto(){
        List<Integer> numberList = Stream.iterate(0, n -> n + 1)
                                        .limit(45)
                                        .collect(Collectors.toList());
        Collections.shuffle(numberList);
        return new Lottos(numberList.stream().
                limit(6)
                .sorted()
                .map(number->new Lotto(number))
                .collect(Collectors.toList()));
    }

    public List<Lotto> getLottos() {
        return lottoList;
    }
}
