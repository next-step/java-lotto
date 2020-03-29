package study.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket implements Iterable<LottoNumber> {
    public static final int PRICE = 1000;

    private Set<LottoNumber> lotto;

    private LottoTicket() {
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        if (!LottoRule.isComplianceNumberRule(lottoNumbers)) {
            throw new IllegalArgumentException("중복없는 6개의 로또 숫자를 입력하세요.");
        }

        setLotto(lottoNumbers);
    }

    public int size() {
        return lotto.size();
    }

    private void setLotto(List<Integer> lottoNumbers) {
        lotto = new HashSet<>();
        for (int number : lottoNumbers) {
            lotto.add(new LottoNumber(number));
        }
    }

    public LottoTicket clone() {
        LottoTicket clonedLottoTicket = new LottoTicket();
        clonedLottoTicket.lotto = lotto.stream()
                .map(LottoNumber::clone)
                .collect(Collectors.toSet());

        return clonedLottoTicket;
    }

    public Stream<LottoNumber> stream() {
        return lotto.stream();
    }

    @Override public Iterator<LottoNumber> iterator() {
        return lotto.iterator();
    }
}
