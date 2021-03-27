package step2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private List<LottoNumber> lottoNumberList;

    private static List<Integer> numberList;

    public Lotto(String lottoNumberList){
        this(Arrays.stream(lottoNumberList.split(","))
                .map(number->new LottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> lottoNumberList){
        this.lottoNumberList = lottoNumberList;
    }

    static {
        numberList = Stream.iterate(1, n -> n + 1)
                .limit(45)
                .collect(Collectors.toList());
    }

    public static Lotto generate(){
        Collections.shuffle(numberList);
        return new Lotto(numberList.stream().
                limit(6)
                .sorted()
                .map(number->new LottoNumber(number))
                .collect(Collectors.toList()));
    }

    public HitCount isWinningLottoList(WinningLotto winningLotto){
        return new HitCount(winningLotto.getLottoNumberList().stream()
                .filter(winningNumber->lottoNumberList.contains(winningNumber))
                .count());
    }

    public List<LottoNumber> getLottoNumberList(){
        return lottoNumberList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumberList, lotto.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }
}
