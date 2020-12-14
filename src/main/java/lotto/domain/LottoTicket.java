package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

public class LottoTicket {

    private static final Integer LOTTO_NUMBER_COUNT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(String lottoNumberValues) {
        this(toSet(lottoNumberValues));
    }

    private static Set<LottoNumber> toSet(String lottoNumbers) {
        validate(lottoNumbers);

        String[] numberValues = lottoNumbers.replaceAll(" ", "").split(",");
        return Stream.of(numberValues)
              .map(LottoNumber::new)
              .collect(Collectors.toSet());
    }

    private static void validate(String lottoNumbers) {
        if (StringUtils.isBlank(lottoNumbers)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throwException();
        }

        if (LOTTO_NUMBER_COUNT != lottoNumbers.size()) {
            throwException();
        }
    }

    public int matchCount(LottoTicket lastWinningTicket) {
        Set<LottoNumber> compareLottoTicket = new HashSet<>(this.lottoNumbers);
        compareLottoTicket.retainAll(lastWinningTicket.lottoNumbers);

        return compareLottoTicket.size();
    }

    private void throwException() {
        throw new IllegalArgumentException("6개의 로또 번호를 입력해주세요");
    }

    @Override
    public String toString() {
        List<LottoNumber> displayList = new ArrayList<>(this.lottoNumbers);
        Collections.sort(displayList);
        return displayList.toString();
    }
}
