package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<Integer> lottoNumbers) {
        List<LottoNumber> lottoNumberList = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        validateSize(lottoNumberList);
        validateDuplicate(lottoNumberList);
        this.lottoNumbers = lottoNumberList;
    }

    private static void validateSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private static void validateDuplicate(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }

    public Rank match(final List<LottoNumber> winningLottoTicket) {
        int count = Math.toIntExact(this.lottoNumbers.stream()
                .filter(winningLottoTicket::contains)
                .count());
        return Rank.of(count);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
