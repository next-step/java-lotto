package view;

import domain.lotto.Lotto;
import domain.lotto.vo.LottoNumber;
import domain.lotto.vo.LottoResult;
import domain.lotto.vo.Prize;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

  public void print(String result) {
    System.out.println(result);
  }

  public void print(Lotto lotto){
    List<Integer> lottoNumbers = lotto.getNumbers().stream().map(LottoNumber::getNumber)
        .collect(Collectors.toList());
    System.out.println(lottoNumbers.toString());
  }

  public void printLottoResult(LottoResult result){
    StringBuilder sb = new StringBuilder();
    sb.append("당첨 통계\n--------\n");
    for(var entry : result.getMatchedResult().entrySet()){
      sb.append(String.format("%d개 일치 (%d원)- %d개\n", entry.getKey(), Prize.findPrizeMoneyByCount(entry.getKey()), entry.getValue()));
    }
    sb.append(String.format("\n총 수익률은 %.2f입니다.%s", result.getProfitRate(), result.getProfitRate() >= 1 ? " -> 이익입니다." : " -> 손해입니다."));
    System.out.println(sb.toString());
  }

}
