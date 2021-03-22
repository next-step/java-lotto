package lotto.domain;

import lotto.dto.IssueNumber;
import lotto.dto.LottoNumber;

import java.util.*;

public class LottoPlay {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_LENGTH = 6;
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    public static final List<LottoNumber> LOTTO_NUMBER = new ArrayList<>();
    private final TotalLottoNumbers totalLottoNumbers = new TotalLottoNumbers();
    private int issueNumber;

    public LottoPlay() {
        this.issueNumber = 1;
    }

    static {
        for (int number = LOTTO_MIN; number <= LOTTO_MAX; number++) {
            LOTTO_NUMBER.add(new LottoNumber(number));
        }
    };

    public Map<IssueNumber, LottoNumbers> getLottoNumbers() {
        return totalLottoNumbers.getTotalLottoNumbers();
    }

    public void createLotto(int inputBuyAmount) {
        int countLotto = inputBuyAmount / LOTTO_PRICE;

        while (issueNumber <= countLotto) {
            totalLottoNumbers.recordEachLottoNumbers(new IssueNumber(issueNumber++), createLottoNumber());
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

        return new LottoNumbers(lottoNumber);
    }

    public void createLottoByManual(List<Integer> manualLottoNumber) {
        List<LottoNumber> lottoNumber = new ArrayList<>();

        for (Integer number : manualLottoNumber) {
            lottoNumber.add(new LottoNumber(number));
        }

        totalLottoNumbers.recordEachLottoNumbers(new IssueNumber(issueNumber++), new LottoNumbers(lottoNumber));
    }
}
