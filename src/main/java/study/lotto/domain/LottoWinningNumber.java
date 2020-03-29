package study.lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinningNumber {
    private Set<LottoNumber> winningNumber;

    public LottoWinningNumber(int[] winningNumbers) {
        if (!LottoRule.isComplianceNumberRule(winningNumbers)) {
            throw new IllegalArgumentException("중복없는 6개의 로또 숫자를 입력하세요.");
        }

        setWinningNumber(winningNumbers);
    }

    private void setWinningNumber(int[] winningNumbers) {
        winningNumber = new HashSet<>();
        for (int number : winningNumbers) {
            winningNumber.add(new LottoNumber(number));
        }
    }

    public int size() {
        return winningNumber.size();
    }

    public List<LottoNumber> getMatches(LottoTicket lottoTicket) {
        List<LottoNumber> matches = new ArrayList<>();

        for(LottoNumber lottoNumber: lottoTicket) {
            if(winningNumber.contains(lottoNumber)) {
                matches.add(lottoNumber);
            }
        }

        return matches;
    }

}
