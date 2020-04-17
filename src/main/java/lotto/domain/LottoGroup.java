package lotto.domain;

import java.util.*;

public class LottoGroup {
    private final List<Lotto> lottos;

    private LottoGroup(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(new ArrayList<>(lottos));
    }

    public LottoGroup(Lotto... lottos) {
        this(Arrays.asList(lottos));
    }

    public static LottoGroup buyLotto(int countOfLotto, List<String> manualLottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (String numbers : manualLottoNumbers) {
            lottos.add(Lotto.ofComma(numbers));
        }
        lottos.addAll(buyAutoSelectLotto(countOfLotto));
        return new LottoGroup(lottos);
    }

    private static List<Lotto> buyAutoSelectLotto(int countOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(Lotto.of(getNumbers(random)));
        }
        return lottos;
    }

    private static List<Integer> getNumbers(Random random) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < Lotto.LOTTO_SIZE) {
            numbers.add(random.nextInt(LottoNumber.MAX_VALUE) + LottoNumber.MIN_VALUE);
        }
        return new ArrayList<>(numbers);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Ranks matching(WinningLotto winningLotto) {
        List<Rank> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(winningLotto.match(lotto));
        }
        return new Ranks(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGroup that = (LottoGroup) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
