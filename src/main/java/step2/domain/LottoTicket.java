package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<LottoNumber> lottoNumbers;
    public static final int LOTTO_NUM_COUNT=6;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        checkLottoCount(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(String lottoNumbers) {

        Set<LottoNumber> newLottoNumbers = Arrays.stream(lottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted(Comparator.comparingInt(Integer::intValue))
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        checkLottoCount(newLottoNumbers);
        this.lottoNumbers = newLottoNumbers;
    }

    private void checkLottoCount(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또는 6개여야 합니다.");
        }
    }

    public int winningCount(LottoTicket winningTicket) {
        return (int) lottoNumbers.stream()
                .filter(winningTicket::contains)
                .count();
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

}
