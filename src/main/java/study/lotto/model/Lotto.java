package study.lotto.model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성 되어야 합니다.");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto generate() {
        return new Lotto(LottoNumber.generateLottoNumbers());
    }

    public static Lotto of(List<LottoNumber> lottoNumberList) {
        return new Lotto(new TreeSet<>(lottoNumberList));
    }

    public static int calculateNumOfLottos(int totalPrice) {
        return totalPrice / LOTTO_PRICE;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public long compareToWinningNumbers(WinningLotto winningLotto) {
        return lottoNumbers
                .stream()
                .filter(winningLotto.getLottoNumbers()::contains)
                .count();
    }

    private boolean containsBonusNumber(int bonusNumber) {
        return lottoNumbers.contains(new LottoNumber(bonusNumber));
    }

    public LottoRank getLottoRank(WinningLotto winningLotto, int bonusNumber) {
        return LottoRank.find(
                (int)compareToWinningNumbers(winningLotto),
                containsBonusNumber(bonusNumber));
    }

    public String toString() {
        return lottoNumbers
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList())
                .toString();
    }
}
