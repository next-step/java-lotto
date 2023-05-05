package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinnerLotto {
    private static final int FIRST_INDEX = 0;
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinnerLotto(LottoNumbers lottoNumbers, LottoNumber lottoNumber) {
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
}
