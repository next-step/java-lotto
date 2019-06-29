package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static step2.domain.LottoConstant.LOTTO_NUMBERS;
import static step2.domain.LottoConstant.LOTTO_NUMBER_SIZE;

public class Lotto {
    private static final Integer LOTTO_NUMBERS_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public Lotto(Lotto lotto) {
        validateSize(lotto.lottoNumbers);
        this.lottoNumbers = lotto.getLottoNumbers();
    }

    private void validateSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개가 필요합니다. 입력된 로또 번호 갯수 : " + lottoNumbers.size());
        }
    }

    public static Lotto create() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(LOTTO_NUMBERS.subList(0, LOTTO_NUMBER_SIZE));
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                                .map(LottoNumber::new)
                                .collect(Collectors.toList()));
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public LottoRank matchLottoNumber(WinningLotto lotto) {
        final long count = matchCount(lotto.getLotto());
        LottoRank rank = LottoRank.matchOf((int) count);

        if (isStopBonusTrack(rank)) {
            return rank;
        }

        BonusNumber bonusNumber = lotto.getBonusNumber().orElseThrow(() -> new IllegalArgumentException("bonus number 가 필요합니다."));
        return matchBonusNumber(rank, bonusNumber);
    }

    private long matchCount(final Lotto lotto) {
        return this.lottoNumbers.stream()
                                .filter(lotto.lottoNumbers::contains)
                                .count();
    }

    private boolean isStopBonusTrack(LottoRank rank) {
        return !LottoRank.THIRD.equals(rank);
    }

    private LottoRank matchBonusNumber(final LottoRank rank, final BonusNumber bonusNumber) {
        if (this.lottoNumbers.contains(bonusNumber)) {
            return LottoRank.SECOND;
        }

        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
