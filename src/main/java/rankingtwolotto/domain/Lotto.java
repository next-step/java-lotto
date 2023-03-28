package rankingtwolotto.domain;

import rankingtwolotto.rankingexception.ExceptionCommand;
import rankingtwolotto.rankingexception.RankingValueException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLotto(List<LottoNumber> lotto) {
        if (lotto.isEmpty() || lotto == null) {
            throw new RankingValueException(ExceptionCommand.INPUT_EXCEPTION_MESSAGE);
        }
        if (lotto.size() != lotto.stream().map(LottoNumber::getLottoNumber).distinct().count()) {
            throw new RankingValueException(ExceptionCommand.LOTTO_DUPLICATION_EXCEPTION_MESSAGE);
        }
        if (lotto.size() != LOTTO_NUMBER_COUNT) {
            throw new RankingValueException(ExceptionCommand.WINNING_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static List<LottoNumber> getRandomLotto() {
        return sortLotto(createRandomLotto());
    }

    private static List<LottoNumber> createRandomLotto() {
        List<LottoNumber> randomLotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            randomLotto.add(new LottoNumber((int) (Math.random() * 45 + 1)));
        }
        return randomLotto;
    }

    private static List<LottoNumber> sortLotto(List<LottoNumber> lotto) {
        return lotto.stream()
                .sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLotto() {
        return this.lottoNumbers;
    }

    public String toString(Lotto lotto) {
        String lottoString = "[";
        for (LottoNumber lottoNumber : lotto.getLotto()) {
            lottoString += lottoNumber.getLottoNumber() + ", ";
        }
        lottoString = lottoString.substring(0, lottoString.length() - 2) + "]";
        return lottoString;
    }

}
