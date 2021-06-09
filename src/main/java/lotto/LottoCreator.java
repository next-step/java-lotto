package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCreator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_INCREMENT_INDEX = 1;
    private static final int LOTTO_NUMBER_MIN_COUNT = 0;
    private static final int LOTTO_NUMBER_MAX_COUNT = 6;
    private static final String COMMA = ", ";

    private static List<LottoNumber> lottoNumbers;
    private List<LottoNumber> lottoTicket;
    private List<LottoTicket> lottoTicketList;
    private LottoTickets lottoTickets;

    static {
        lottoNumbers = IntStream.iterate(MIN_NUMBER, i -> i + LOTTO_NUMBER_INCREMENT_INDEX)
                .limit(MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTicket makeLottoTicket() {
        shuffleLottoNumbers();
        lottoTicket = new ArrayList<>
                (lottoNumbers.subList(LOTTO_NUMBER_MIN_COUNT, LOTTO_NUMBER_MAX_COUNT));
        sortLottoNumbers();
        return new LottoTicket(lottoTicket);
    }

    private void shuffleLottoNumbers() {
        Collections.shuffle(lottoNumbers);
    }

    private void sortLottoNumbers() {
        Collections.sort(lottoTicket);
    }

    public LottoTickets makeLottoTickets(int lottoCount) {
        lottoTicketList = new ArrayList<>();
        lottoTickets = new LottoTickets(lottoTicketList);
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.putLottoTicket(makeLottoTicket());
        }
        return lottoTickets;
    }

    public WinningLotto makeWinningNumber(String enteredWinningNumber, int bonusNumber) {
        return new WinningLotto(Arrays.stream(enteredWinningNumber.split(COMMA))
                .map(value -> new LottoNumber(Integer.parseInt(value)))
                .collect(Collectors.toList()), new LottoNumber(bonusNumber));
    }
}
