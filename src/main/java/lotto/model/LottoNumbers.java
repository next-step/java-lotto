package lotto.model;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class LottoNumbers {
    private List<LottoNumber> lottoNubmers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNubmers, that.lottoNubmers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNubmers);
    }

    public boolean contains(LottoNumber lottoNumber){
        return lottoNubmers.contains(lottoNumber);
    }

    public LottoNumbers(List<LottoNumber> lottoNubmers) {
        this.lottoNubmers = lottoNubmers;
    }

    @Override
    public String toString(){
        StringJoiner strJoiner = new StringJoiner(",");
        for (LottoNumber lottoNubmer : lottoNubmers) {
            strJoiner.add( Integer.toString(lottoNubmer.number()) );
        }
        return "[" + strJoiner.toString() + "]";
    }

    public LottoNumber get(int index){
        return lottoNubmers.get(index);
    }

    public LottoNumbers shuffle() {
        Collections.shuffle(lottoNubmers);
        return this;
    }

    public LottoNumbers sort(){
        Collections.sort(lottoNubmers);
        return this;
    }
}
