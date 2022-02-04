package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;

public class LottoInputView {

    private static final String SPACE = " ";
    private static final String COMMA = ",";
    private static final String LEFT_SQUARE_BRACKETS = "[";
    private static final String RIGHT_SQUARE_BRACKETS = "]";
    private static final int ZERO = 0;

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
        stringBuilder.append(LEFT_SQUARE_BRACKETS);

        for (LottoNumber lottoNumber : lottoNumbers) {
            stringBuilder.append(lottoNumber.getNumber())
                .append(COMMA)
                .append(SPACE);
        }

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(SPACE));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(COMMA));
        stringBuilder.append(RIGHT_SQUARE_BRACKETS);

        System.out.println(stringBuilder);
        stringBuilder.setLength(ZERO);
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
