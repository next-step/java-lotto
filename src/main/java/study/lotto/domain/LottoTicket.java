package study.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket implements Iterable<LottoNumber> {
    private static final String CONSTRUCTOR_ERROR_MESSAGE = "중복없는 6개의 로또 숫자를 " +
            "입력하세요.";
    public static final int PRICE = 1000;

    private Set<LottoNumber> lottoNumber;

    private LottoTicket() {
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        if (!LottoRule.isComplianceNumberRule(lottoNumbers)) {
            throw new IllegalArgumentException(CONSTRUCTOR_ERROR_MESSAGE);
        }

        setLottoNumber(lottoNumbers);
    }

    public int size() {
        return lottoNumber.size();
    }

    public List<LottoNumber> getLottoNumber() {
        return lottoNumber.stream()
                .map(LottoNumber::clone)
                .sorted()
                .collect(Collectors.toList());
    }

    private void setLottoNumber(List<Integer> lottoNumbers) {
        lottoNumber = new HashSet<>();
        for (int number : lottoNumbers) {
            lottoNumber.add(new LottoNumber(number));
        }
    }

    public LottoTicket clone() {
        LottoTicket clonedLottoTicket = new LottoTicket();
        clonedLottoTicket.lottoNumber = lottoNumber.stream()
                .map(LottoNumber::clone)
                .collect(Collectors.toSet());

        return clonedLottoTicket;
    }

    @Override public Iterator<LottoNumber> iterator() {
        return lottoNumber.iterator();
    }
}
