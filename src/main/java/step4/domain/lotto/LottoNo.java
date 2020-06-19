package step4.domain.lotto;

public class LottoNo implements Comparable {

    private final int lottoNo;

    public LottoNo(int lottoNo) {
        this.lottoNo = lottoNo;
    }

    public int getLottoNo() {
        return lottoNo;
    }

    @Override
    public int compareTo(Object o) {
        if (this.lottoNo == ((LottoNo) o).getLottoNo()) {
            return 0;
        }
        return ((LottoNo)o).getLottoNo() > this.lottoNo ? -1 : 1;
    }
}
