package lotto.model;

public class LottoGenerator {
    private CandidateLottoNumbers candidateLottoNumbers;

    public LottoGenerator(CandidateLottoNumbers candidateLottoNumbers) {
        this.candidateLottoNumbers = candidateLottoNumbers;
    }

    public LottoTicket generate(){
        return candidateLottoNumbers.getRandomLottoTicket();
    }

}
