package step3.lotto.domain.numbers;

import step3.lotto.util.LottoErrorMessage;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoTicket {

    private static int LOTTO_MAKE_COUNT = 6;

    private final SortedSet<Integer> lottoTicket;

    LottoTicket(List<Integer> lotto) {
        checkLottoSize(lotto);
        checklottoOverlapNumbers(lotto);
        this.lottoTicket = new TreeSet<>(lotto);
    }

    private static void checkLottoSize(List<Integer> lottoTicket) {
        if (lottoTicket.size() != LOTTO_MAKE_COUNT) {
            throw new RuntimeException(LottoErrorMessage.getLottoMakeCountCheck());
        }
    }

    private void checklottoOverlapNumbers(List<Integer> paramList) {
        for (int i = 0; i < paramList.size() - 1; i++) {
            goInListData(i, paramList);
        }
    }

    private void goInListData(int index, List<Integer> paramList) {
        for (int j = index + 1; j < paramList.size(); j++) {
            isSameValue(index, j, paramList);
        }
    }

    private void isSameValue(int firstIndex, int secondIndex, List<Integer> paramList) {
        if (paramList.get(firstIndex) == paramList.get(secondIndex)) {
            throw new RuntimeException(LottoErrorMessage.getLottoOverlapCheck());
        }
    }

    public SortedSet<Integer> getLottoTicket() {
        return lottoTicket;
    }
}
