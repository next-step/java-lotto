package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> LOTTO_CANDIDATE_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    private List<Integer> lottoNumbers;
    private LottoResult lottoResult;

    public Lotto() {
        createLotto(generateAutoLottoNumbers(), new LottoResult());
    }

    public Lotto(List<Integer> lottoNumbers) {
        createLotto(lottoNumbers, new LottoResult());
    }

    private void createLotto(List<Integer> lottoNumbers, LottoResult lottoResult){
        this.lottoNumbers = lottoNumbers;
        validateLottoNumbers(this.lottoNumbers);
        this.lottoResult = lottoResult;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public int getMatchCount() {
        return this.lottoResult.getMatchCount();
    }

    public String toStringLottoNumbers() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }

    public List<Integer> generateAutoLottoNumbers() {
        Collections.shuffle(LOTTO_CANDIDATE_NUMBERS);
        return LOTTO_CANDIDATE_NUMBERS.stream().limit(LOTTO_NUMBER_COUNT).collect(Collectors.toList());
    }

    public int calculateMatchCount(Lotto winningLotto, int bonusNumber) {
        return this.lottoResult.calculateMatchCount(winningLotto.getLottoNumbers(), lottoNumbers, bonusNumber);
    }

    public int getAmount() {
        return this.lottoResult.getAmountForWinningLotto();
    }

    public static boolean validateLottoNumbers(List<Integer> numbers) { //todo private
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("번호 갯수가 6개가 아닙니다.");
        }
        for (Integer number : numbers) {
            validateLottoNumber(number);
        }
        return true;
    }

    private static boolean validateLottoNumber(int lottoNumber) {
        if (lottoNumber <= 0 || lottoNumber > 45) {
            throw new IllegalArgumentException("유효한 번호가 아닙니다.");
        }
        return true;
    }
}
