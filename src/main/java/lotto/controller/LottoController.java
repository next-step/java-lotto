package lotto.controller;

import lotto.model.*;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private CandidateLottoNumbers candidateLottoNumbers;

    public LottoController(CandidateLottoNumbers candidateLottoNumbers) {
        this.candidateLottoNumbers = candidateLottoNumbers;
    }

    public List<LottoTicket> generate(int numLottoTicket){
        List<LottoTicket> tickets = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator(candidateLottoNumbers);
        for (int i=0; i<numLottoTicket; i++){
            LottoTicket temp = lottoGenerator.generate();
            tickets.add(temp);
        }
        return tickets;
    }

    public LottoResult run(WinningLottoTicket winningTicket, List<LottoTicket> userLottoTickets, int expense) {
        LottoGame lottoGame = new LottoGame(winningTicket, userLottoTickets);
        ScoreMap scoreMap = lottoGame.getScores();
        return new LottoResult(scoreMap, expense);
    }
}
