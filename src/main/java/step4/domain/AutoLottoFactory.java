package step4.domain;

import step4.exception.LottoMoneyException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoFactory {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;

    public AutoLottoFactory(final int money, final LottoGeneratorStrategy lottoMakeStrategy) {
        validMoney(money);


        lottos = makeAutoLotto(money, lottoMakeStrategy);
    }

    private List<Lotto> makeAutoLotto(int money, LottoGeneratorStrategy lottoMakeStrategy) {
        return IntStream.range(0, getLottoTicketCount(money))
                .mapToObj(i -> new Lotto(lottoMakeStrategy.generateLottoNumbers()))
                .collect(Collectors.toList());
    }

    public void addList(List<Lotto> lottoList) {
        lottoList.addAll(lottos);
    }

    private int getLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getLottoTicketCount() {
        return lottos.size();
    }

    private void validMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new LottoMoneyException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoLottoFactory that = (AutoLottoFactory) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
