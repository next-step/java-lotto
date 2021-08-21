package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {
    private static final List<Integer> numberCards = new ArrayList<>();
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    static {
        for (int i = LOTTO_FIRST_NUMBER; i <= LOTTO_LAST_NUMBER; i++) {
            numberCards.add(i);
        }
    }

    public LottoTicket generateLottoTicket() {
        LottoTicket lottoTicket = new LottoTicket();
        Collections.shuffle(numberCards);

        ArrayList<Integer> sortedLottoNumber = new ArrayList<>(numberCards.subList(0, 6));
        Collections.sort(sortedLottoNumber);
        lottoTicket.saveLottoNumbers(sortedLottoNumber);
        return lottoTicket;
    }

}
