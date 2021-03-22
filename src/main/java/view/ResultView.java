package view;

import domain.LottoResultResponse;

public class ResultView {

    public ResultView(LottoResultResponse lottoResultResponse){
        printLottoTickets(lottoResultResponse);

        System.out.println("당첨 통계");
        System.out.println("---------");

    }

    private void printLottoTickets(LottoResultResponse lottoResultResponse) {
        lottoResultResponse
        .getLottoList()
        .getLottoList()
        .forEach(lotto ->
            System.out.println(
                lotto.getLottoNumbers().getNumbers()
            )
        );
    }
}
