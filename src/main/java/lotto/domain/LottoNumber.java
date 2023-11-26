package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber>{
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public boolean isThisNumberMatched(int number) {
        return this.lottoNumber == number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return 0;
    }

    public int lottoNumber() {
        return this.lottoNumber;
    }

}
