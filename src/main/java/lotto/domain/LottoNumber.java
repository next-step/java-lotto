package lotto.domain;

import java.util.List;

public class LottoNumber implements Comparable<LottoNumber>{
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    public boolean isThisNumberMatched(int number) {
        return this.lottoNumber == number;
    }

    public boolean isThisNumberMatched(List<Integer> winnerNumbers) {
        return winnerNumbers.contains(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return 0;
    }

    public int lottoNumber() {
        return this.lottoNumber;
    }

}
