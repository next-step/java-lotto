package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    List<Integer> lottoNumber;

    public Lotto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public String getStringLottoNumber(){
        return lottoNumber.toString();
    }

    public long correctNum(List<Integer> winNumbers){
        return winNumbers.stream()
                .filter(num -> lottoNumber.contains(num))
                .count();
    }
}
