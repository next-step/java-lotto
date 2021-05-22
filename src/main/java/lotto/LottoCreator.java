package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCreator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_MIN_COUNT = 0;
    private static final int LOTTO_NUMBER_MAX_COUNT = 6;

    private List<LottoNumber> lottoNumbers;

    public void makeLottoNumbers() {
        lottoNumbers = IntStream.iterate(MIN_NUMBER, i -> i + 1).limit(MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void shuffleLottoNumbers() {
        makeLottoNumbers();
        Collections.shuffle(lottoNumbers);
    }

    private void sortLottoNumbers() {
        Collections.sort(lottoNumbers);
    }

    public LottoTicket makeLottoTicket() {
        shuffleLottoNumbers();
        lottoNumbers = lottoNumbers.subList(LOTTO_NUMBER_MIN_COUNT, LOTTO_NUMBER_MAX_COUNT);
        sortLottoNumbers();
        return new LottoTicket(lottoNumbers);
    }

    public LottoTickets makeLottoTickets(int lottoCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        sortLottoNumbers();
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(makeLottoTicket());
        }
        return new LottoTickets(lottoTickets);
    }
}
