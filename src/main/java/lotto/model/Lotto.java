package lotto.model;

import lotto.dto.LottoNumberDto;
import lotto.exception.InvalidLottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        assertLotto(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    private void assertLotto(List<LottoNumber> lottoNumbers) {
        assertNullOrEmpty(lottoNumbers);
        assertInvalidSize(lottoNumbers);
    }

    private void assertNullOrEmpty(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new InvalidLottoException("로또 번호가 비어 있습니다");
        }
    }

    private void assertInvalidSize(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(lottoNumbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new InvalidLottoException("중복을 제외한 " + LOTTO_NUMBER_SIZE + "개의 로또 번호가 필요합니다");
        }
    }

    public List<LottoNumber> value() {
        return lottoNumbers;
    }

//    public Rank match(Lotto other) {
//        if (other == null) {
//            throw new InvalidLottoException("매칭할 수 있는 로또가 존재하지 않습니다");
//        }
//
//        Set<LottoNumber> lottoNumberSet = new HashSet<>(this.lottoNumbers);
//        lottoNumberSet.retainAll(other.lottoNumbers);
//
//        return Rank.find(lottoNumberSet.size());
//    }

    public Rank match(WinningInfo winningInfo) {
        if (winningInfo == null) {
            throw new InvalidLottoException("당첨 번호 정보가 존재하지 않습니다");
        }

        return winningInfo.findRank(this);
    }

    public LottoNumberDto toLottoNumberDto() {
        List<String> numbers = this.lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.toList());

        return new LottoNumberDto(numbers);
    }

    public boolean contains(LottoNumber bonus) {
        return this.lottoNumbers.contains(bonus);
    }

    public int uniqueNumberSize(Lotto other) {
        Set<LottoNumber> unique = new HashSet<>(this.lottoNumbers);
        unique.retainAll(other.lottoNumbers);
        return unique.size();
    }
}
