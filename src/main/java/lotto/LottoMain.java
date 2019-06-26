package lotto;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int amount = Input.getAmount();
        int issueCount = amount / 1000;

        LottoMachine lm = new LottoMachine();
        List<Lotto> lottos = lm.issue(issueCount);

        System.out.println(lottos.size() + "개를 구매하였습니다.");
        Result.printLottos(lottos);
        System.out.println();

        String inputWinningNumbers = Input.getWinningNumber();
        List<Integer> winningNumbers = StringUtil.convertIntList(StringUtil.split(inputWinningNumbers));

        if (Input.isValidNumbers(winningNumbers)){
            System.out.println(winningNumbers);
            System.out.println();

        }

    }


}
