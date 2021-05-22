package lotto.view;

import lotto.controller.dto.LottoNumbersDto;
import lotto.controller.dto.LottoPurchaseResponse;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printPurchaseResult(LottoPurchaseResponse response) {
        System.out.println(response.getLottoNumbersDtoList().size() + "개를 구매했습니다.");
        printLottoNumberList(response.getLottoNumbersDtoList());
    }

    private void printLottoNumberList(List<LottoNumbersDto> lottoNumbersDtoList) {
        for (LottoNumbersDto lottoNumbersDto : lottoNumbersDtoList) {
            System.out.println("[" + printLottoNumbers(lottoNumbersDto) + "]");
        }
    }

    private String printLottoNumbers(LottoNumbersDto lottoNumbersDto) {
        return lottoNumbersDto.getLottoNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
