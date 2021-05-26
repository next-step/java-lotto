package lotto.model;

public class UserLottoRequest {
    private int expense;
    private int numLottoTicket;
    private LottoGame lottoGame;

    public UserLottoRequest(int expense, int numLottoTicket, LottoGame lottoGame) {

        this.expense = expense;
        this.numLottoTicket = numLottoTicket;
        this.lottoGame = lottoGame;
    }
    public void checkWin(){
        LottoResultMap lottoResultMap = new LottoResultMap(expense);
        for (int i=0; i<numLottoTicket; i++){
            LottoGenerator lottoGenerator = new LottoGenerator(new RandomGenerateRule());
            LottoNumbers generated = lottoGenerator.generate();
            lottoResultMap.plusByNumKeyMatched(lottoGame.howManyMatched(generated));
            System.out.println(generated.sort().toString());
        }

        lottoResultMap.printResult();
    }
}
