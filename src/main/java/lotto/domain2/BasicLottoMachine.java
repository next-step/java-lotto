package lotto.domain2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BasicLottoMachine implements LottoMachine {
    private static final String DIRECT_NUMBERS_DELIMITER = ", ";
    private final List<LottoNumber> baseLottoNumbers;

    public BasicLottoMachine() {
        this.baseLottoNumbers = new ArrayList<>();

        for (int no = LottoNumber.MIN; no <= LottoNumber.MAX; no++) {
            baseLottoNumbers.add(LottoNumber.of(no));
        }
    }

    @Override
    public Lottos issue(final int countOfTotalLotto, final List<String> directLottos) {
        final List<Lotto> lottos = new ArrayList<>();
        final int countOfAutoLotto = countOfTotalLotto - directLottos.size();

        lottos.addAll(issueDirectLotto(directLottos));
        lottos.addAll(issueAutoLotto(countOfAutoLotto));

        return new Lottos(lottos);
    }

    private List<Lotto> issueDirectLotto(final List<String> directLottos) {
        final List<Lotto> lottos = new ArrayList<>();

        for (String directLotto : directLottos) {
            String[] directLottoNumbers = directLotto.split(DIRECT_NUMBERS_DELIMITER);
            lottos.add(issueDirectLotto(directLottoNumbers));
        }

        return lottos;
    }

    private Lotto issueDirectLotto(final String[] directLottoNumbers) {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String directLottoNumber : directLottoNumbers) {
            LottoNumber lottoNumber = LottoNumber.of(Integer.parseInt(directLottoNumber));
            lottoNumbers.add(lottoNumber);
        }

        return new Lotto(lottoNumbers, true);
    }

    private List<Lotto> issueAutoLotto(final int countOfLotto) {
        final List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < countOfLotto; i++) {
            Collections.shuffle(baseLottoNumbers);
            List<LottoNumber> lottoNumbers = new ArrayList<>(baseLottoNumbers.subList(0, Lotto.NUMBER_COUNT));
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicLottoMachine that = (BasicLottoMachine) o;
        return Objects.equals(baseLottoNumbers, that.baseLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseLottoNumbers);
    }
}
