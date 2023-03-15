package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private final List<Integer> lottoNumberList;

    public LottoNumbers(List<Integer> lottoNumberList) {
        numberListCheck(lottoNumberList);
        this.lottoNumberList = lottoNumberList;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumberList;
    }

    private void numberListCheck(List<Integer> lottoNmberList) {
        if (lottoNmberList.size() != lottoNmberList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복 숫자 발생");
        }

        if (lottoNmberList.stream().anyMatch(e -> e > 45 || e < 1)) {
            throw new IllegalArgumentException("유효하지 않은 로또 숫자");
        }

        if (lottoNmberList.size() > 6) {
            throw new IllegalArgumentException("로또는 6자리 이다");
        }
    }
}
