package lotto.domain;

import java.util.Objects;

public class LottoGame {
    public static final int NUMBER_BOUND = 6;

    private final Numbers numbers;
    private final LottoNumberService lottoNumberService;

    public LottoGame(Numbers numbers) {
        this(new ManualNumberService(numbers));
    }

    public LottoGame(LottoNumberService lottoNumberService) {
        this.lottoNumberService = lottoNumberService;
        this.numbers = this.lottoNumberService.creation();
    }

    public HitResult lotto(WinNumbers winNumbers) {
        return new HitResult(numbers, winNumbers);
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public LottoNumberService getLottoNumberService() {
        return lottoNumberService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(numbers, lottoGame.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
