package step2.domain;

import step2.domain.strategy.LottoGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<String> lottoNumbers = new ArrayList<>();
    private LottoGeneratorStrategy lottoGeneratorStrategy;

    public Lotto(LottoGeneratorStrategy lottoGeneratorStrategy) {
        this.lottoGeneratorStrategy = lottoGeneratorStrategy;
    }

    public void generateNumber() {
        while (lottoNumbers.size() < Constants.MAX_LOTTO_NUMBER_SIZE) {
            String lottoNum = String.valueOf(lottoGeneratorStrategy.getLottoNumber());

            if (!lottoNumbers.contains(lottoNum))
                lottoNumbers.add(lottoNum);
        }
    }

    public int getMatchCount(List<String> winningNumber) {
        return (int) lottoNumbers.stream()
                .filter(winningNumber::contains)
                .count();
    }

    @Override
    public String toString() {
        return "[" + String.join(", ", lottoNumbers) + "]";
    }
}
