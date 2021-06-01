package lotto.model;

public class LottoGenerator {
    private final int LOTTO_DIGIT_SIZE = 6;
    private CandidateLottoNumbers candidateLottoNumbers;

    public LottoGenerator(CandidateLottoNumbers candidateLottoNumbers) {
        this.candidateLottoNumbers = candidateLottoNumbers;
    }

    public LottoTicket generate(){
        return candidateLottoNumbers.getRandomLottoTicket();
    }

}
