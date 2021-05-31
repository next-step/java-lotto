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

    @Override
    public String toString(){
        StringJoiner strJoiner = new StringJoiner(",");
        for (LottoNumber lottoNubmer : lottoNubmers) {
            strJoiner.add( Integer.toString(lottoNubmer.number()) );
        }
        return "[" + strJoiner.toString() + "]";
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

    public LottoTicket shuffle() {
        Collections.shuffle(lottoNubmers);
        return this;
    }

    public LottoTicket sort(){
        Collections.sort(lottoNubmers);
        return this;
    }

    public int howManyMatched(LottoTicket that){
        int totalNumContains = 0;
        for (int i=0; i<that.size(); i++){
            totalNumContains += howManyContains(that.get(i));
        }
        return totalNumContains;
    }

    private int size() {
        return lottoNubmers.size();
    }

    private int howManyContains(LottoNumber lottoNumber){
        if (lottoNubmers.contains(lottoNumber)){
            return 1;
        }
        return 0;
    }

}
