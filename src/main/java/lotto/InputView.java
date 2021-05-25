package lotto;

import java.util.Scanner;

public class InputView {
    public static final String LOTTO_BUY_PAY_INPUT = "구입금액을 입력해 주세요.";
    public static final String WIN_LOTTO_NUMBER_INPUT = "지난 주 당첨 번호를 입력해 주세요.";

    private final Scanner scanner;
    private final LottoBuy lottoBuy;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.lottoBuy = new LottoBuy();
    }

    public Lottos lottoBuyStart() {
        Lottos lottos = new Lottos();
        try {
            System.out.println(LOTTO_BUY_PAY_INPUT);
            int pay = this.scanner.nextInt();
            lottos = lottoBuy.buyLotto(pay);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.scanner.nextLine();
        }
        return lottos;
    }

    public Lotto inputWinLottoNumber() {
        String winNumber = "";
        try {
            System.out.println(WIN_LOTTO_NUMBER_INPUT);
            winNumber = this.scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.scanner.close();
        }
        return new Lotto(LottoValidationUtils.lottoNumberToList(winNumber));
    }
}
