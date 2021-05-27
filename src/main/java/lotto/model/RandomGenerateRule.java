package lotto.model;

public class RandomGenerateRule implements GenerateRule{
    private LottoTicket candidateNumbers;
    private int cursor;

    public RandomGenerateRule() {
        this.cursor = 0;
        this.candidateNumbers = CandidateLottoGenerator.generate().shuffle();
    }

    @Override
    public void init(){
        this.cursor = 0;
        this.candidateNumbers.shuffle();
    }

    @Override
    public LottoNumber generate() {
        return candidateNumbers.get(cursor++);
    }

}
