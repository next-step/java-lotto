package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new ArrayList<>();
    }

    public void add(Integer lottoNumber) {
        lottoNumbers.add(lottoNumber);
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return String.valueOf(lottoNumbers);
    }

    public LottoType contains(List<Integer> abd, int bonusNumber) {
        int answer = 0;
        int bonusAnswer = 0;
        for (Integer value : abd) {
            if (lottoNumbers.contains(value)) {
                answer++;
            }
        }

        if (lottoNumbers.contains(bonusNumber)) {
            bonusAnswer++;
        }
        return LottoType.of(answer, bonusAnswer);
    }
}
