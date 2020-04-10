package lotto.domain;

import java.util.*;

public class LottoGroup {
    private final List<Lotto> lottos;

    private LottoGroup(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(new ArrayList<>(lottos));
    }

    public LottoGroup(Lotto... lottos) {
        this.lottos = Arrays.asList(lottos.clone());
    }

    public static LottoGroup buyAutoSelectLotto(int countOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(Lotto.of(getNumbers(random)));
        }
        return new LottoGroup(lottos);
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

    public List<Rank> matching(WinningLotto winningLotto) {
        List<Rank> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(lotto.match(winningLotto));
        }
        return result;
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
