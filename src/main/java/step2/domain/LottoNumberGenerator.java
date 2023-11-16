package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    public List<LottoNumbers> lottoNumbers(int count) {
        List<LottoNumbers> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(new LottoNumbers());
        }

        return result;
    }

    public List<LottoNumbers> lottoNumbers(List<List<Integer>> lottoNumbers) {
        return lottoNumbers.stream()
            .map(LottoNumbers::new)
            .collect(Collectors.toList());
    }

}
