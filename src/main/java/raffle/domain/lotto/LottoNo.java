package raffle.domain.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNo implements Comparable<LottoNo> {
    private Integer lottoNumber;

    private static final Map<Integer, LottoNo> lottoCache = new HashMap<>();

    public LottoNo(int lottoNumber){
        this.lottoNumber = lottoNumber;
    }

    public static LottoNo in(int lottoNumber){
        if(lottoCache.containsKey(lottoNumber)){
            LottoNo lottoNo = lottoCache.get(lottoNumber);
            return lottoNo;
        }
        LottoNo lottoNo = new LottoNo(lottoNumber);
        lottoCache.put(lottoNumber, lottoNo);
        return lottoNo;
    }

    @Override
    public int compareTo(LottoNo lottoNumber) {
        return Integer.compare(this.lottoNumber, lottoNumber.getLottoNumber());
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    public boolean isLottoNumber(List<LottoNo> lottoNumber) {
        return lottoNumber.stream().anyMatch(lottoNo -> lottoNo.equals(this));
    }

    @Override
    public String toString() {
        return this.lottoNumber.toString();
    }
}
