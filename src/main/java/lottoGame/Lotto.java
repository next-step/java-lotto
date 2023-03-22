package lottoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Lotto {

    public static final int LOTTO_MIN_NUMBER_RANGE = 1;
    public static final int LOTTO_MAX_NUMBER_RANGE = 45;
    public static final int LOTTO_NUMBERS = 6;
    private List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = getNewLottoNumber();
    }
    private List<Integer> getNewLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<Integer>();

        for (int i = LOTTO_MIN_NUMBER_RANGE; i <= LOTTO_MAX_NUMBER_RANGE; i++) {
            lottoNumbers.add(i);
        }

        Collections.shuffle(lottoNumbers);

        List<Integer> lottoTicket = new ArrayList<>();
        for(int i = 0; i < LOTTO_NUMBERS; i++) {
            lottoTicket.add(lottoNumbers.get(i));
        }
        Collections.sort(lottoTicket);

        return lottoTicket;
    }
    public List<Integer> getLottoNumber() {
        return lottoNumbers;
    }

    public String toString() {
        return lottoNumbers.toString();
    }
}
