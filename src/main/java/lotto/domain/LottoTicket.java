package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int PICK_NUMBERS = 6;

    List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            this.lottoNumbers.add(i);
        }
    }

    public LottoTicket(List<Integer> ticketNumbers) {
        this.lottoNumbers = new ArrayList<>(ticketNumbers);
    }

    public List<Integer> issueTicket() {
        Collections.shuffle(this.lottoNumbers);
        this.lottoNumbers = this.lottoNumbers.subList(0, PICK_NUMBERS);
        Collections.sort(this.lottoNumbers);

        return this.lottoNumbers;
    }

}
