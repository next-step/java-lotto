package autolotto;

public class Lottery {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        LottoOutput lottoOutput = new LottoOutput();
        Lottos lottos = new Lottos();

        int lottoQuantity = lottoInput.askQuantity("구입 장수를 입력해주세요. 1장 당 1000원이며 양수만 입력 가능합니다. ex. 14000 -> 14");
        lottoOutput.println(lottoQuantity + "장을 구입했습니다.");

        for (int count = 0; count < lottoQuantity; count++) {
            Lotto lotto = new Lotto(new LottoGenerator().generate());
            lottos.add(lotto);
            lottoOutput.println(lotto.toString());
        }

        String numbers = lottoInput.askWinningNumber("지난주 당첨 번호를 콤마(,)를 기준으로 입력해주세요. ex. 1,2,3,4,5,6");
        WinningLotto winningLotto = new WinningLotto(numbers);

        Results results = lottos.confirm(winningLotto);

        lottoOutput.printResult(results);
        lottoOutput.printProfit(lottos, results);
    }
}
