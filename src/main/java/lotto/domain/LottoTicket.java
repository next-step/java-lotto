package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    public static final int ONE_TICKET_LOTTO_NUMBER = 6;
    public static final int ONE_TICKET_PRICE = 1000;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private static final List<Integer> allLottoNumbers = new ArrayList<>();
    static {
        for (int number = LOTTO_NUMBER_MIN; number <= LOTTO_NUMBER_MAX; ++number) {
            allLottoNumbers.add(number);
        }
    }

    private List<Integer> lottoNumbers;

    private LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket create() {
        Collections.shuffle(allLottoNumbers);

        return new LottoTicket(allLottoNumbers.subList(0, ONE_TICKET_LOTTO_NUMBER));
    }

    public static LottoTicket create(Integer... numbers) {
        return new LottoTicket(Arrays.asList(numbers));
    }

    public int countLottoNumber() {
        return lottoNumbers.size();
    }

    public LottoResult checkLottery(List<Integer> winLottoNumbers) {
        int fitCount = 0;
        for (Integer winNumber : winLottoNumbers) {
            if (lottoNumbers.contains(winNumber)) {
                ++fitCount;
            }
        }

        return LottoResult.of(fitCount);
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
            "lottoNumbers=" + lottoNumbers +
            '}';
    }
}
