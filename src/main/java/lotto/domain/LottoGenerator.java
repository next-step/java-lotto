package lotto.domain;

import lotto.view.InputView;

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
            possibleLottoNumbers.add(LottoNumber.of(i));
        }
    }

    private Lotto generateOneLottoTicket() {
        Collections.shuffle(possibleLottoNumbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_CAPACITY; i++) {
            lottoNumbers.add(possibleLottoNumbers.get(i));
        }
        return new Lotto(lottoNumbers);

    }

    public List<Lotto> generateLottoTicketsAutomatically(int numberOfTicket) {
        // 1로또를 만든다
        // 이 것을 리스트형태로 넘버오브티켓만큼 반복한다
        List<Lotto> playersLottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTicket; i++) {
            Lotto playersLotto = generateOneLottoTicket();
            playersLottoTickets.add(playersLotto);
        }
        return playersLottoTickets;
    }

    public List<Lotto> generateLottoTicketsManually(int numberOfTicket) {
        List<Lotto> ManualPlayersLottoTickets = new ArrayList<>();
        InputView.printNumberOfManualLotto();
        for (int i = 0; i < numberOfTicket; i++) {
            List <LottoNumber> manualLotto = getLottoWithSplitting(InputView.getStringOfLotto());
            ManualPlayersLottoTickets.add(new Lotto(manualLotto));
        }
        return ManualPlayersLottoTickets;
    }

    public List<Lotto> purchaseManualAndAutoLottoTickets(int numberOfTicket, int numberOfManualLotto) {
        int NumberOfAutoLotto = numberOfTicket-numberOfManualLotto;
        Validator.isNegative(NumberOfAutoLotto);
        List<Lotto> playersLottoTickets = generateLottoTicketsManually(numberOfManualLotto);
        playersLottoTickets.addAll(generateLottoTicketsAutomatically(NumberOfAutoLotto));

        return playersLottoTickets;

    }
    public static List<LottoNumber> getLottoWithSplitting(String text) {
        String [] inputs = text.split(Lotto.DELIMITER);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String input : inputs) {
            lottoNumbers.add(LottoNumber.of(Validator.checkIsIntegerAndIsNegative(input)));
        }
        Lotto.checkSizeOfLotto(lottoNumbers);
        return lottoNumbers;
    }
}
