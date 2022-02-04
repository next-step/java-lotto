package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;

public class LottoInputView {

    private final StringBuilder stringBuilder = new StringBuilder();

    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusBall;
    private Lottos lottos;
    private int userPrice;

    public void prepareLottoGame(final LottoShop lottoShop) {
        System.out.println("구입금액을 입력해 주세요.");
        userPrice = LottoInput.inputPrice();
        int lottoAmount = lottoShop.countPossibleLottoAmount(userPrice);
        System.out.println(lottoAmount + "개를 구매했습니다.");

        lottos = lottoShop.buyLotto();

        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto.getLotto());
        }

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        winningNumbers = LottoInput.inputWinningNumber();

        System.out.println("보너스 볼을 입력해주세요.");
        bonusBall = new LottoNumber(LottoInput.inputBonusBall());
    }

    private void printLotto(final List<LottoNumber> lottoNumbers) {
        stringBuilder.append("[");

        for (LottoNumber lottoNumber : lottoNumbers) {
            stringBuilder.append(lottoNumber.getNumber())
                .append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("]");

        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
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

    public int getPrice() {
        return this.userPrice;
    }
}
