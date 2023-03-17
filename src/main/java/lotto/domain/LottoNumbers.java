package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class LottoNumbers {
    private List<Integer> lottoNumberList;

    public LottoNumbers(List<Integer> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
        numberListCheck(lottoNumberList);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumberList;
    }

    private void numberListCheck(List<Integer> lottoNmberList) {
        if (lottoNmberList.size() != lottoNmberList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복 숫자 발생");
        }

        if (lottoNmberList.size() > 6) {
            throw new IllegalArgumentException("로또는 6자리 이다");
        }

        for (int lottoNumber : lottoNumberList) {
            new LottoNumber(lottoNumber);
        }
    }
}
