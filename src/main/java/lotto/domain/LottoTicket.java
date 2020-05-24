package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final static int LOTTO_MAX_NUMBER = 45;
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_TICKET_SIZE = 6;

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    private LottoTicket() {
        for (int i = LOTTO_MIN_NUMBER; i < LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        shuffleLottoTicket();
    }

    public static LottoTicket create() {
        return new LottoTicket();
    }

    private void shuffleLottoTicket() {
        Collections.shuffle(this.lottoNumbers);

        List<LottoNumber> newLottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_TICKET_SIZE; i++) {
               newLottoNumbers.add(this.lottoNumbers.get(i));
        }

        Collections.sort(newLottoNumbers);
        this.lottoNumbers =  newLottoNumbers;
    }

    public int size() {
        return this.lottoNumbers.size();
    }

    public void printLottoNumbers() {
        List<Integer> collect = this.lottoNumbers.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());

        System.out.println(collect.toString());
    }
}
