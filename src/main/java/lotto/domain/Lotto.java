package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lotto {
    private static final int START_SPLIT_NUMBERS = 0;
    private static final int END_SPLIT_NUMBERS = 6;
    private static final int START_RANGE_LOTTO_NUMBERS = 1;
    private static final int END_RANGE_LOTTO_NUMBERS = 46;

    private List<LottoNumber> lottoNumbers;

    public Lotto(){
        generateAutoLottoNumbers();
    }

    public Lotto(String winLottoNumbers) {
        String[] splitWinLottoNumbers = winLottoNumbers.split(",");
        this.lottoNumbers = Stream.of(splitWinLottoNumbers)
                .map(m -> new LottoNumber((Integer.parseInt(m.trim()))))
                .collect(Collectors.toList());
    }

    private void generateAutoLottoNumbers(){
        List<LottoNumber> lottoNumbers = IntStream.range(START_RANGE_LOTTO_NUMBERS,END_RANGE_LOTTO_NUMBERS)
                                                    .mapToObj(LottoNumber::new)
                                                    .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        this.lottoNumbers = lottoNumbers.subList(START_SPLIT_NUMBERS, END_SPLIT_NUMBERS);
        System.out.println(this.lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
