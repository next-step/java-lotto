package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuyLotto {
    private static final int LOTTO_PRICE = 1000;
    private final int money;
    private final Lottos lottos;
    private final int manualLottoCount;

    public BuyLotto(int money) {
        validate(money);
        this.money = money;
        this.lottos = new Lottos(new LottoGenerator(), buyLottoCount());
        this.manualLottoCount = 0;
    }

    public BuyLotto(int money, LottoGenerator lottoGenerator) {
        validate(money);
        this.money = money;
        this.lottos = new Lottos(lottoGenerator, buyLottoCount());
        this.manualLottoCount = 0;
    }

    public BuyLotto(int money, List<String[]> manualLotto) {
        validate(money);
        this.money = money;
        this.manualLottoCount = manualLotto.size();
        this.lottos = new Lottos(new LottoGenerator(), makeManualLotto(manualLotto), buyLottoCount());
    }

    private void validate(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또는 1게임 당 1,000원 입니다.");
        }
    }

    private List<Lotto> makeManualLotto(List<String[]> manualLotto) {
        List<Lotto> manualLottos = new ArrayList<>();
        for(String[] lotto : manualLotto) {
            List<LottoNumber> lottoNumbers = Arrays.stream(lotto)
                    .map(s -> new LottoNumber(Integer.parseInt(s)))
                    .collect(Collectors.toList());
            manualLottos.add(new Lotto(lottoNumbers));
        }
        return manualLottos;
    }


    public int buyLottoCount() {
        if(this.manualLottoCount != 0) {
            return (this.money / LOTTO_PRICE) - manualLottoCount ;
        }
        return this.money / LOTTO_PRICE;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
