package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static List<Integer> lottoNumbers = IntStream.range(1, 45)
                                                    .boxed()
                                                    .collect(Collectors.toList());

    public static List<Integer> getNumber(){
        List<Integer> lottoNumber = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < 6; i++) {
            lottoNumber.add(lottoNumbers.get(i));
        }
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}
