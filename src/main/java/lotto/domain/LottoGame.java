package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class LottoGame {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int DEFAULT_DIGIT = 6;

    final int autoCount;
    private final List<LottoTicket> lottoNumbers;

    public LottoGame(InputView inputView) {
        this.autoCount = inputView.getAutoCount();
        this.lottoNumbers = inputView.getManualLotto();
        this.lottoNumbers.addAll(autoLotto());
    }

    public List<LottoTicket> getLottoNumbers(){
        return  lottoNumbers;
    }

    public List<LottoTicket> autoLotto(){

        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            tickets.add(new LottoTicket(getRandomLottoNum()));
        }

        return tickets;
    }

    public List<Integer> getRandomLottoNum(){

        return new Random()
                .ints(MINIMUM_NUMBER, (MAXIMUM_NUMBER + 1))
                .distinct()
                .limit(DEFAULT_DIGIT)
                .sorted()
                .boxed()
                .collect(toList());
    }

}