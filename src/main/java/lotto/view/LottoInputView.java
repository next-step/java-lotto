package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;

public class LottoInputView {

    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusBall;
    private Lottos lottos;

    public void prepareLottoGame(final LottoShop lottoShop) {
        System.out.println("구입금액을 입력해 주세요.");
        final int price = LottoInput.inputPrice();
        int lottoAmount = lottoShop.countPossibleLottoAmount(price);
        System.out.println(lottoAmount + "개를 구매했습니다.");

        lottos = lottoShop.buyLotto();

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        winningNumbers = LottoInput.inputWinningNumber();

        System.out.println("보너스 볼을 입력해주세요.");
        bonusBall = new LottoNumber(LottoInput.inputBonusBall());
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
