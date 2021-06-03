package lotto.model;
import java.util.*;

public class LottoTicket {
    private List<LottoNumber> lottoNubmers = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNubmers, that.lottoNubmers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNubmers);
    }

    public boolean contains(LottoNumber lottoNumber){
        return lottoNubmers.contains(lottoNumber);
    }

    public LottoTicket(List<LottoNumber> lottoNubmers) {
        this.lottoNubmers = lottoNubmers;
    }

    public List<LottoNumber> getLottoNumbers(){
        return Collections.unmodifiableList(this.lottoNubmers);
    }

    public LottoNumber get(int index) {
        if(index >= lottoNubmers.size()){
            try {
                throw new Exception("index out of range");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lottoNubmers.get(index);
    }

    public int size() {
        return lottoNubmers.size();
    }
}
