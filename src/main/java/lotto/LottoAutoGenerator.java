package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator {

    private LottoAutoGenerator(){}

    public static List<Integer> generateLotto(){
        List<Integer> lottoAllNum = IntStream.range(1, 45)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(lottoAllNum);

        return lottoAllNum.subList(0, 6);
    }
}
