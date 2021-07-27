package lotto.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LottoTickets {

    private static final int START_INDEX = 0;
    private final List<LottoNumbers> lottoNumbers;
    private final Integer[] generateNumbers = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER)
            .boxed()
            .toArray(Integer[]::new);

    private LottoTickets(Money money) {
        this.lottoNumbers = buyLotto(money);
    }

    public static LottoTickets of(long money) {
        return new LottoTickets(Money.of(money));
    }

    public List<LottoNumbers> getLottoTickets() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private List<LottoNumbers> buyLotto(Money money) {
        long size = money.lottoTicketCount();
        List<LottoNumbers> numbers = new ArrayList<>();
        LongStream.range(START_INDEX, size)
                .forEach((s) -> numbers.add(generateLottoNumbers()));

        return numbers;
    }

    private LottoNumbers generateLottoNumbers() {
        Integer[] clone = generateNumbers.clone();
        List<Integer> cloneList = Arrays.asList(clone);
        Collections.shuffle(cloneList);
        List<Integer> numbers = cloneList.subList(START_INDEX, LottoNumber.LOTTO_NUMBER_SIZE);

        return new LottoNumbers(numbers);
    }
}
