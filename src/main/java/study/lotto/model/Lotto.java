package study.lotto.model;

import java.util.Arrays;
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

    private Lotto(List<LottoNumber> lottoNumberList) {
        this(new TreeSet<>(lottoNumberList));
    }

    private Lotto() {
        this(LottoNumber.generateLottoNumbers());
    }

    public static Lotto auto() {
        return new Lotto();
    }

    public static Lotto of(List<LottoNumber> lottoNumberList) {
        return new Lotto(lottoNumberList);
    }

    public static Lotto of(String[] lottoNumbers) {
        List<LottoNumber> lottoNumberList = Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        return new Lotto(lottoNumberList);
    }

    public static int calculateTotalPrice(int numOfLottos) {
        return numOfLottos * LOTTO_PRICE;
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
                .filter(winningLotto::contains)
                .count();
    }

    private boolean containsBonusNumber(int bonusNumber) {
        return lottoNumbers.contains(LottoNumber.of(bonusNumber));
    }

    public LottoRank checkLottoRank(WinningLotto winningLotto, int bonusNumber) {
        return LottoRank.find(
                (int)compareToWinningNumbers(winningLotto),
                containsBonusNumber(bonusNumber));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public String toString() {
        return lottoNumbers
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList())
                .toString();
    }
}
