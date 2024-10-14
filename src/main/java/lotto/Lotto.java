package lotto;

import java.util.*;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final Random RANDOM = new Random();

    private List<Integer> lottoNumbers;
    private LottoResult lottoResult;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers = generateAutoLottoNumbers();
        validateLottoNumbers(lottoNumbers);
        lottoResult = new LottoResult();
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validateLottoNumbers(this.lottoNumbers);
        lottoResult = new LottoResult();
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public int isEqualMatchCount(int matchCount) {
        return lottoResult.isEqualMatchCount(matchCount);
    }

    public String toStringLottoNumbers() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }

    public List<Integer> generateAutoLottoNumbers() {
        while (lottoNumbers.size() < LOTTO_NUMBER_COUNT) {
            generateLottoNumber();
        }

        Collections.shuffle(this.lottoNumbers);
        return this.lottoNumbers;
    }

    private void generateLottoNumber() {
        int randomNumber = RANDOM.nextInt(45) + 1;
        if (!lottoNumbers.contains(randomNumber)) {
            lottoNumbers.add(randomNumber);
        }
    }

    public int calculateMatchCount(Lotto winningLotto) {
        return this.lottoResult.calculateMatchCount(winningLotto.getLottoNumbers(), lottoNumbers);
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
