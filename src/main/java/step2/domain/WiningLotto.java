package step2.domain;

public class WiningLotto {
    private final Lottos lottos;
    private final LottoNumbers winningNumbers;

    public WiningLotto(Lottos lottos, LottoNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public int[] getWinner() {

        return lottos.getStream().mapToInt(lotto -> {
            lotto.getLotto()
                    .getNumbers()
                    .retainAll(this.winningNumbers.getNumbers());
            return lotto.getLotto()
                    .getNumbers()
                    .size();
        }).sorted().toArray();
    }
}
