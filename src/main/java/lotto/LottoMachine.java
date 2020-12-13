package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {
    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static int BASE_INDEX = 0;
    private final List<LottoNumber> lottoNumbers;

    public LottoMachine() {
        this.lottoNumbers = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTicket generate() {
        lottoNumbersShuffle();
        return new LottoTicket(new ArrayList<>(lottoNumbers.subList(BASE_INDEX, LOTTO_NUMBER_COUNT)));
    }

    public LottoTickets generate(int purchaseQuantity) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        Stream.generate(this::generate)
                .limit(purchaseQuantity)
                .forEach(lottoTickets::add);
        return new LottoTickets(lottoTickets);
    }

    private void lottoNumbersShuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public WinningNumber winningNumber(String winningNumberString) {
        return new WinningNumber(Arrays.stream(winningNumberString.split(", "))
                .map(value -> new LottoNumber(Integer.parseInt(value)))
                .collect(Collectors.toList()));
    }
}
