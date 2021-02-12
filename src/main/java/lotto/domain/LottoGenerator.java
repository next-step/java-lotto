package lotto.domain;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.*;


public class LottoGenerator {
    private static final int VALUE_LEFT_BOUND = 1;
    private static final int VALUE_RIHGT_BOUND = 46;

    private static final int COUNT_LEFT_BOUND = 0;
    private static final int COUNT_RIGHT_BOUND = 6;

    private static final int BONUS_INDEX = 6;

    private static List<LottoNumber> candidateNumbers = new ArrayList<>();

    static {
        for (int i = VALUE_LEFT_BOUND; i < VALUE_RIHGT_BOUND; i++) {
            candidateNumbers.add(new LottoNumber(i));
        }
    }

    // for lotto machine (bonus number)
    public static LottoTicket generateLotto(LottoNumber bonus) {
        Collections.shuffle(candidateNumbers);

        List<LottoNumber> selectedNumbers = candidateNumbers.subList(
                COUNT_LEFT_BOUND, COUNT_RIGHT_BOUND
        );
        Collections.sort(selectedNumbers);

        return new LottoTicket(selectedNumbers, bonus);
    }

    // overload for buyer : candidateNumbers를 사용하면 랜덤 시드를 다르게 줘도 동일한 셔플 결과만 반환 하는 문제를 해결
    public static LottoTicket generateLotto(int j) {
        List<LottoNumber> candidateNumbersBuyer = new ArrayList<>();
        for (int i = VALUE_LEFT_BOUND; i < VALUE_RIHGT_BOUND; i++) {
            candidateNumbersBuyer.add(
                    new LottoNumber(i)
            );
        }

        Collections.shuffle(candidateNumbersBuyer, new Random(j));

        List<LottoNumber> selectedNumbers = candidateNumbersBuyer.subList(
                COUNT_LEFT_BOUND, COUNT_RIGHT_BOUND
        );
        Collections.sort(selectedNumbers);

        return new LottoTicket(selectedNumbers);
    }

    public static LottoNumber generateBonus() {
        return candidateNumbers.get(BONUS_INDEX);
    }

    public static List<LottoTicket> rawToTickets(List<String> lottosManualRaw) {
        List<LottoTicket> lottoManualTickets = new ArrayList<>();
        for(String raw : lottosManualRaw){
            lottoManualTickets.add(rawToTicket(raw));
        }
        return lottoManualTickets;
    }

    public static LottoTicket rawToTicket(String raw) {
        return new LottoTicket(raw);
    }
}
