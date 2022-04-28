package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class LottoTicket {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int ONE_TICKET_PRICE = 1000;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private static final List<Integer> allLottoNumbers = new ArrayList<>();
    static {
        for (int number = LOTTO_NUMBER_MIN; number <= LOTTO_NUMBER_MAX; ++number) {
            allLottoNumbers.add(number);
        }
    }

    private final int bonusNumber;

    private List<Integer> lottoNumbers;

    private LottoTicket(List<Integer> lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoTicket create() {
        Collections.shuffle(allLottoNumbers);

        return new LottoTicket(
            new ArrayList<>(allLottoNumbers.subList(0, LOTTO_NUMBER_COUNT)),
            new Random().nextInt(LOTTO_NUMBER_MAX+1)
        );
    }

    public static LottoTicket create(int bonusNumber, Integer... numbers) {
        return new LottoTicket(Arrays.asList(numbers), bonusNumber);
    }

    public int countLottoNumber() {
        return lottoNumbers.size();
    }

    public LottoResult checkLottery(final List<Integer> winLottoNumbers, int bonusNumber) {
        int fitCount = (int) lottoNumbers.stream()
            .filter(winLottoNumbers::contains)
            .count();

        return LottoResult.of(fitCount, isFitBonusNumber(bonusNumber));
    }

    private boolean isFitBonusNumber(int bonusNumber) {
        return this.bonusNumber == bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
