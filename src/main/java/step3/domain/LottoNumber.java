package step3.domain;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private int validateLottoNumber(int lottoNumber) {
        if (lottoNumber > LOTTO_END_NUMBER || lottoNumber < LOTTO_START_NUMBER) {
            throw new IllegalArgumentException("번호형식이 틀렸습니다.");
        }
        return lottoNumber;
    }

    @Override
    public int compareTo (final LottoNumber o){
        return Integer.compare(this.lottoNumber, o.lottoNumber);
    }

    public LottoNumber() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoNumber);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
