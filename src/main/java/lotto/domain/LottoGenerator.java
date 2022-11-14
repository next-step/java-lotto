package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    public static final int LOTTO_LENGTH = 6;
    public static final int LOTTO_RANGE = 45;

    public Lottos generate(int countTryNumber) {

        if (countTryNumber <= 0) {
            throw new IllegalArgumentException();
        }

        Lottos lottos = new Lottos();

        for (int i = 0; i<countTryNumber; i++){
            lottos.add(randomGenerate());
        }
        return lottos;
    }

    private Lotto randomGenerate() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        IntStream.range(1,LOTTO_RANGE+1).forEach(i -> lottoNumberList.add(LottoNumber.of(i)));
        Collections.shuffle(lottoNumberList);
        return new Lotto(lottoNumberList.subList(0,LOTTO_LENGTH));
    }
}
