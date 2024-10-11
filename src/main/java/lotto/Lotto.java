package lotto;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.purchaseAndGetResult();
    }

    public void purchaseAndGetResult() {
        int lottoTicketCount = inputView.getInputAndPrint();
        LottoTickets lottoTickets = new LottoTickets(issue(lottoTicketCount));

        resultView.getResultAndPrint(lottoTickets);
    }

    private List<LottoTicket> issue(int lottoTicketCount) {
        List<Integer> lottoNumbers = create();
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            Collections.shuffle(lottoNumbers);

            LottoTicket lottoTicket = new LottoTicket(new ArrayList<>(lottoNumbers.subList(0, LOTTO_NUMBERS_SIZE)));
            lottoTickets.add(lottoTicket);

            inputView.print(lottoTicket.toString());
        }
        inputView.print("");

        return lottoTickets;
    }

    private List<Integer> create() {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }

        return lottoNumbers;
    }

}
