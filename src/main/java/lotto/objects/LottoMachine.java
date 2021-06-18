package lotto.objects;

public class LottoMachine {
    private final int total;

    public LottoMachine(int total) {
        this.total = total;
    }

    public Lottos autoCreateLottos() {
        Lottos lottos = new Lottos();

        for (int i = 0; i < total; i++) {
            lottos.addLotto(generateLotto());
        }

        return lottos;
    }

    private Lotto generateLotto() {
        LottoNumbers allNumbers = new LottoNumbers();

        return allNumbers.getRandomNumbers();
    }

    public int getTotal() {
        return total;
    }
}
