package lotto;

public class LottoMachine {

    public static Lottos createLottos(int count, LottoGenerator generator) {
        return generator.generate(count);
    }

}
