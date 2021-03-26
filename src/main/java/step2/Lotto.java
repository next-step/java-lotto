package step2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private List<LottoNumber> lottoNumberList;

    private static List<Integer> numberList;

    public Lotto(List<LottoNumber> lottoNumberList){
        this.lottoNumberList = lottoNumberList;
    }

    static {
        List<Integer> numberList = Stream.iterate(1, n -> n + 1)
                .limit(45)
                .collect(Collectors.toList());
    }

    public void generate(){
        Collections.shuffle(numberList);
        lottoNumberList = numberList.stream().
                limit(6)
                .sorted()
                .map(number->new LottoNumber(number))
                .collect(Collectors.toList());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numberList, lotto.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }
}
