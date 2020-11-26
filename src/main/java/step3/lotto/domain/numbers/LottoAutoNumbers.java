package step3.lotto.domain.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoNumbers {

    private static final int MAKE_LOTTO_NUMBERS_COUNT = 45;  // 로또 생성 갯수
    private List<Integer> basicLottoNumbers = new ArrayList<>();

    LottoAutoNumbers(int makeLottoNumberCount) {
        initLottoNubmers(makeLottoNumberCount);
    }

    private void initLottoNubmers(int makeLottoNumberCount) {
        for (int i = 1; i <= makeLottoNumberCount; i++) {
            basicLottoNumbers.add(i);
        }
    }

    public LottoTicket getAutoNumbers(int getLottoAutoNumberCount) {
        List<Integer> returnList = new ArrayList<>();
        Collections.shuffle(basicLottoNumbers);

        for (int i = 0; i < getLottoAutoNumberCount; i++) {
            returnList.add(basicLottoNumbers.get(i));
        }
        LottoTicket lottoTicket = new LottoTicket(returnList);

        return lottoTicket;
    }
}
