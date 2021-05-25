package lotto.model;

public class RandomGenerateRule implements GenerateRule{
    private LottoNumbers lottoNumbers;
    private int cursor;

    public RandomGenerateRule() {
        this.cursor = 0;
        this.lottoNumbers = CandidateLottoGenerator.generate().shuffle();
    }

    @Override
    public LottoNumber generate() {
        return lottoNumbers.get(cursor++);
    }

    //TODO: cursor 초과 방지
}
