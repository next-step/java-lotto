package Model;

import java.util.ArrayList;
import java.util.Collections;

public class LottoRandomGenerator extends LottoGenerator {
    private static int MIN_NUM = 1;
    private static int MAX_NUM = 45;
    static ArrayList<Lotto> lottos = new ArrayList<>();

    public LottoRandomGenerator() {
    }

    public ArrayList<Lotto> getLottos() {
        return this.lottos;
    }

    @Override
    public void generatorLotto(int count) {
        for (int i = 0; i < count; i++) {
            this.lottos.add(makeAutoLotto());
        }
    }

    public Lotto makeAutoLotto() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = MIN_NUM; i <= MAX_NUM; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        ArrayList<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lotto.add(numbers.get(i));
        }

        return new Lotto(lotto);
    }
}
