package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<Number> lottoNumbers;

    private static final int SIZE = 6;

    public Lotto() {
    }

    private Lotto(List<Number> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createLotto(List<Number> list) {
        if (list.size() > SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개 까지 입니다.");
        }

        return new Lotto(list);
    }


    public List<Number> createLotto() {
        return lottoNumbers;
    }

    public void shuffleLottoNumber(LottoBalls lottoBalls) {
        var numberList = new ArrayList<>(LottoBalls.getLottoNumbers());
        Collections.shuffle(numberList);
        lottoNumbers = new ArrayList<>(numberList.subList(0, SIZE));
    }

    public int equalsCount(List<Number> list) {
        return (int) lottoNumbers.stream()
                .filter(list::contains)
                .count();
    }

    public void sortLotto() {
        Collections.sort(lottoNumbers);
    }

    @Override
    public String toString() {
        sortLotto();
        return "[" + lottoNumbers.stream()
                .map(Number::getNumberToString)
                .collect(Collectors.joining(", ")) + "]" ;
    }
}
