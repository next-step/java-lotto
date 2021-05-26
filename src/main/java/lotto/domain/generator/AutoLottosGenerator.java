package lotto.domain.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicketCount;
import lotto.domain.Money;

public class AutoLottosGenerator implements LottosGenerator{
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static List<LottoNumber> allLottoNumbers = new ArrayList<>();

    static {
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
            .forEach(i -> allLottoNumbers.add(LottoNumber.of(i)));
    }

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < money.countOfLotto(); i++) {
            lottoList.add(generateAuto());
        }
        return lottoList;
    }

    @Override
    public List<Lotto> generate(LottoTicketCount ticketCount) {
        List<Lotto> lottoList = new ArrayList<>();
        return lottoList;
    }

    private Lotto generateAuto() {
        Collections.shuffle(allLottoNumbers);
        return new Lotto(allLottoNumbers.stream()
            .limit(LOTTO_SIZE)
            .collect(Collectors.toList()));
    }
}
