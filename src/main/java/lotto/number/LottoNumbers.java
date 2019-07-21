package lotto.number;

import lotto.LottoRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers from(String lottoNumbersString) {
        String[] lotteryNumberStrings = lottoNumbersString.split(",");
        if (lotteryNumberStrings.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalStateException("the count of lotto number must be " + LOTTO_NUMBER_COUNT);
        }
        List<LottoNumber> lottoNumbers = Arrays.stream(lotteryNumberStrings)
                                               .map(LottoNumber::of)
                                               .distinct()
                                               .collect(Collectors.toList());

        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalStateException("the lotto number must be distinct");
        }

        return new LottoNumbers(lottoNumbers);
    }

    public LottoRank toLottoRank(LottoNumbers winnerLottoNumbers, LottoNumber bonusLottoNumber) {
        if (winnerLottoNumbers.lottoNumbers.contains(bonusLottoNumber)) {
            throw new IllegalStateException("the bonus number isn't contains in winner lotto number list");
        }

        int countOfMatch = (int) winnerLottoNumbers.lottoNumbers.stream()
                                                                .filter(this.lottoNumbers::contains)
                                                                .count();

        boolean isBonusMatched = this.lottoNumbers.contains(bonusLottoNumber);

        return LottoRank.valueOf(countOfMatch, isBonusMatched);
    }
}
