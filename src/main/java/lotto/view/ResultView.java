package lotto.view;

import lotto.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void view(List<LottoNumber> lottoNumbers) {
        List<Integer> integers = lottoNumbers.stream()
                .map(value -> value.intValue())
                .collect(Collectors.toList());
        System.out.println(integers);
    }
}
