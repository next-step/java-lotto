package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNumber> lottoNumberList;

    public Lotto(List<LottoNumber> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }


    public static Lotto of(List<Integer> numbers) {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (Integer number : numbers) {
                lottoNumberList.add(LottoNumber.of(number));
        }
        return new Lotto(lottoNumberList);
    }


    @Override
    public String toString() {
        return lottoNumberList.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(","));
    }

    /*
    public int containsCount(List<LottoNumber> lastWeekWinningLotto) {
        return (int) lastWeekWinningLotto.stream()
                .filter(lottoNumberList::contains)
                .count();
    }

     */
    public int containsCount(Lotto lastWeekWinningLotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lottoNumberList) {
            count += lastWeekWinningLotto.increaseCount(lottoNumber);
        }
        return count;
    }

    private int increaseCount(LottoNumber lottoNumber) {
        if(contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumberList.contains(lottoNumber);
    }
}
