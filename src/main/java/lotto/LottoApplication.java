package lotto;

import lotto.view.InputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        InputView input = new InputView();
        Buyer buyer = new Buyer();
        MatchResult result = new MatchResult();
        // 로또 입력
        // 금액 입력
        int amount = input.inputAmount();
        // 로또 실행
        // 구매
        // 번호 당첨
        int tickets = buyer.matchPriceAndPayment(amount);
        // TODO : 한 장 만들기. 여러 장 만들기로 바꿔야

        for(int i=0; i<tickets; i++){
            LottoTicket ticket = LottoGenerator.generateLotto();
            int matchCount = lotto.matchLotto(ticket); // 몇 개 맞췄는지 반환
            result.countUpMatch(matchCount);
        }

        // return result to output view
        List<Integer> res = result.getResult();
        Double resRevenue = result.CalculateWinningRevenue();
        // 결과 출력
        OutputView.printResult(res);
        OutputView.printRevenue(resRevenue);
    }

}
