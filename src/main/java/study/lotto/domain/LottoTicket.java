package study.lotto.domain;

import java.util.*;

public class LottoTicket implements Iterable<LottoNumber> {
    public static final int PRICE = 1000;

    private Set<LottoNumber> lotto;

    public LottoTicket(int[] lottoNumbers) {
        if (!LottoRule.isComplianceNumberRule(lottoNumbers)) {
            throw new IllegalArgumentException("중복없는 6개의 로또 숫자를 입력하세요.");
        }

        setLotto(lottoNumbers);
    }

    public int size() {
        return lotto.size();
    }

    private void setLotto(int[] lottoNumbers) {
        lotto = new HashSet<>();
        for (int number : lottoNumbers) {
            lotto.add(new LottoNumber(number));
        }
    }

    @Override public Iterator<LottoNumber> iterator() {
        return lotto.iterator();
    }
}
