package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String LOTTO_WINNER_NUMBER_INPUT_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    public static final String LOTTO_WINNER_BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String LOTTO_BUY_AMT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_BUY_MANUAL_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String LOTTO_BUY_MANUAL_NUMBER_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public static int inputBuyLottoPrice() {
        System.out.println(LOTTO_BUY_AMT_INPUT_MESSAGE);
        try {
            int buyPrice = scanner.nextInt();
            return buyPrice;
        } catch (Exception e) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }
    public static int inputBuyManualLottoQty() {
        System.out.println(LOTTO_BUY_MANUAL_INPUT_MESSAGE);
        try{
            int buyQty = scanner.nextInt();
            return buyQty;
        } catch (Exception e) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }

    public static LottoTicket inputBuyManualLottoNumber(int buyQty) {
        List<Lotto> lottoList = new ArrayList<>();
        System.out.println(LOTTO_BUY_MANUAL_NUMBER_INPUT_MESSAGE);
        for(int i=0; i<buyQty; i++){
            LottoNumber[] inputNumbers = inputLottoNumbers();
            lottoList.add(Lotto.of(inputNumbers));
        }
        return LottoTicket.from(lottoList);
    }

    public static LottoWinner inputWinnerLottoNumber() {
        System.out.println(LOTTO_WINNER_NUMBER_INPUT_MESSAGE);
        LottoNumber[] inputNumbers = inputLottoNumbers();
        LottoNumber bonusNumber = inputWinnerBonusLottoNumber();
        return LottoWinner.of(inputNumbers, bonusNumber);
    }

    private static LottoNumber[] inputLottoNumbers() {
        try{
            return Arrays.stream(scanner.next().replaceAll(" ", "").split(",")).map(LottoNumber::from).toArray(LottoNumber[]::new);
        }catch(Exception e){
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }

    }

    public static LottoNumber inputWinnerBonusLottoNumber() {
        System.out.println(LOTTO_WINNER_BONUS_NUMBER_INPUT_MESSAGE);
        try{
            return LottoNumber.from(Integer.parseInt(scanner.next()));
        }catch(Exception e){
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }
}
