package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private List<Lotto> lottoTicket;

    public LottoTicket(int number) {
        this.lottoTicket = new ArrayList<>();
        List<LottoNumber> numbers = numberList();
        for (int i = 0; i < number; i++) {
            Collections.shuffle(numbers);
            lottoTicket.add(new Lotto(numbers.subList(0, 6)));
        }
    }

    private static List<LottoNumber> numberList() {
        return IntStream.rangeClosed(1, 45)
                .boxed()
                .map(el -> new LottoNumber(el))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }
}
