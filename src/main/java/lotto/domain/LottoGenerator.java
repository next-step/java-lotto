package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static final int LOWER_BOUND_LOTTO = 1;
    public static final int UPPER_BOUND_LOTTO = 46;
    public static final int LOTTO_CAPACITY = 6;
    private final List<LottoNumber> possibleLottoNumbers = new ArrayList<>();

    public LottoGenerator() {
        for (int i = LOWER_BOUND_LOTTO; i < UPPER_BOUND_LOTTO; i++) {
            possibleLottoNumbers.add(new LottoNumber(i));
        }
    }

    private PlayersLotto generateOneLotto() {
        Collections.shuffle(possibleLottoNumbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_CAPACITY; i++) {
            lottoNumbers.add(possibleLottoNumbers.get(i));
        }
        return new PlayersLotto(lottoNumbers);
    }

    public List<PlayersLotto> generateLottoTickets(PlayersLottoGenerateOption option, List<PlayersLotto> manualLottoTicket) {
        List<PlayersLotto> playersLottoTickets = new ArrayList<>();
        for (int i = 0; i < option.getManualGenerateCnt(); i++) {
            playersLottoTickets.add(manualLottoTicket.get(i));
        }
        for (int i = 0; i < option.getAutoGenerateCnt(); i++) {
            PlayersLotto playersLotto = generateOneLotto();
            playersLottoTickets.add(playersLotto);
        }
        return playersLottoTickets;
    }
}
