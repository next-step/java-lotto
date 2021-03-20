package lotto.domain;

import lotto.dto.IssueNumber;
import lotto.dto.LottoNumber;

import java.util.*;

public class LottoPlay {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final List<LottoNumber> LOTTO_NUMBER = new ArrayList<>();
    private final Map<IssueNumber, List<LottoNumber>> totalLottoNumbers = new HashMap<>();

    static {
        for (int number = LOTTO_MIN; number <= LOTTO_MAX; number++) {
            LOTTO_NUMBER.add(new LottoNumber(number));
        }
    };

    public Map<IssueNumber, List<LottoNumber>> getLottoNumbers() {
        return totalLottoNumbers;
    }

    public void createLotto(int inputBuyAmount) {
        int countLotto = inputBuyAmount / LOTTO_PRICE;

        for (int issueNumber = 1; issueNumber <= countLotto; issueNumber++) {
            totalLottoNumbers.put(new IssueNumber(issueNumber), createLottoNumber().getLottoNumbers());
        }
    }

    public LottoNumbers createLottoNumber() {
        List<LottoNumber> lottoNumber = new ArrayList<>();

        Collections.shuffle(LOTTO_NUMBER);
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            lottoNumber.add(new LottoNumber(LOTTO_NUMBER.get(i)
                                                        .getLottoNumber()));
        }
        Collections.sort(lottoNumber);
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumber);

        return lottoNumbers;
    }

    public int getMatchNumbers(List<LottoNumber> lottoNumber, List<Integer> winningNumbers) {
        return (int) lottoNumber.stream()
                .filter(number -> winningNumbers.contains(number.getLottoNumber()))
                .count();
    }
}
