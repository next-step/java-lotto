package step2.domain;

import step2.domain.strategy.LottoNumberGeneratorStrategy;

import java.util.*;

public class Lotto {
    private final int MAX_LOTTO_NUMBER_SIZE = 6;
    private List<Integer> lottoNumbers = new ArrayList<>();

    public void generateNumber(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        while (lottoNumbers.size() < MAX_LOTTO_NUMBER_SIZE) {
            int lottoNum = lottoNumberGeneratorStrategy.generateLottoNumber();

            if (!lottoNumbers.contains(lottoNum))
                lottoNumbers.add(lottoNum);
        }
    }

    public int getMatchCount(Optional<WinningNumbers> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers.orElseThrow(() -> new NoSuchElementException("당첨번호가 필요합니다.")).getWinningNumbers()::contains)
                .count();
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers.toArray());
    }
}
