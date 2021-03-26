package step2.view;

import step2.domain.Lotto.Lotto;
import step2.domain.Lotto.LottoList;
import step2.domain.Lotto.LottoNumber;
import step2.dto.LottoExpressionResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static ResultView instance;

    public static ResultView getInstance(){
        if(isInstanceNull()) {
            instance = new ResultView();
        }
        return instance;
    }

    private static boolean isInstanceNull() {
        return instance == null;
    }

    public void printLottoList(LottoExpressionResponseDto expressionResponseDto) {
        LottoList lottoList = expressionResponseDto.getLottoList();
        List<Lotto> list = lottoList.getLottoList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(list.size()).append("개를 구매했습니다.").append("\n");
        for(Lotto lotto : list)  {
            List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
            String data = lottoNumbers
                    .stream()
                    .map(lottoNumber -> lottoNumber.getLottoNumber())
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]\n"));
            stringBuilder.append(data);
        }
        System.out.println(stringBuilder.toString());

    }
}
