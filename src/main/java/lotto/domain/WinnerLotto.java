package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinnerLotto {
    private static final int FIRST_INDEX = 0;
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinnerLotto(LottoNumbers lottoNumbers, LottoNumber lottoNumber) {
        validateSameNumber(lottoNumbers, lottoNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = lottoNumber;
    }

    public List<Winners> findWinnerList(Lotto lotto) {

        List<Integer> matchingBallList = lotto.countMatchingBall(this.lottoNumbers);
        List<Boolean> bonusNumberMatchingList = lotto.bonusNumberMatchingList(this.bonusNumber);

        return IntStream.range(FIRST_INDEX, matchingBallList.size())
                .mapToObj(index -> {

                    int matchingBall = matchingBallList.get(index);
                    boolean bonusBallMatch = bonusNumberMatchingList.get(index);

                    return new Winners(matchingBall, bonusBallMatch);
                }).collect(Collectors.toUnmodifiableList());
    }

    private void validateSameNumber(LottoNumbers lottoNumbers, LottoNumber lottoNumber) {

        boolean isSame = lottoNumbers.isMatchingLottoNumber(lottoNumber);
        if (isSame) {
            throw new IllegalArgumentException("보너스볼 번호가 당첨 로또에 이미 있는 번호입니다 :(");
        }
    }
}
