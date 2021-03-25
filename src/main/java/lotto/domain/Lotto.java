package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> lottoNumberList;

    public Lotto(int[] lottoNumbers) {
        this.lottoNumberList = Arrays.stream(lottoNumbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }

    public Lotto(List<LottoNumber> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }
}
