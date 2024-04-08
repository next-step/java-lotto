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


    public int checkMatch(List<Integer> targetNumbers) {
        Collections.sort(targetNumbers);

        if (targetNumbers.size() != this.lottoNumbers.size()) {
            throw new IllegalArgumentException("당첨 번호 개수가 일치 하지 않습니다.");
        }

        int count = 0;
        for (int i = 0; i < this.lottoNumbers.size(); i++) {
            count = compareNumbers(targetNumbers, i, count);
        }

        return count;
    }

    private int compareNumbers(List<Integer> targetNumbers, int i, int count) {
        if (this.lottoNumbers.get(i) == targetNumbers.get(i)) {
            count++;
        }
        return count;
    }

}
