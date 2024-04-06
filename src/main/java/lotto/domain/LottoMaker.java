package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public interface LottoMaker {

    String SPLIT_TOKEN =",";

    List<Lotto> create();

     static Lotto convertTextToLotto(String numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers.split(SPLIT_TOKEN))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

}
