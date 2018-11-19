package lotto.view;


import lotto.dto.Rank;
import lotto.service.LottoResult;

import java.util.Map;

public class ResultView {

    public static void gameResult(String result){

        System.out.println("당첨 통계");
        System.out.println("-------");
        System.out.println(result);

    }

    public static void printMatchingResult(Map<Rank,Integer> maps){
        StringBuilder sb = new StringBuilder();

        for(Rank rank : Rank.values()){
            if(rank == Rank.SECOND){
                sb.append(
                        String.format(
                                "%s개 일치, 보너스 볼 일치 (%d원) - %d개\n"
                                ,rank.getMatch()
                                ,rank.getWon()
                                ,maps.get(rank)
                        )
                );
                continue;
            }
            sb.append(
                    String.format(
                            "%s개 일치 (%d원) - %d개\n"
                            ,rank.getMatch()
                            ,rank.getWon()
                            ,maps.get(rank)
                    )
            );
        }


        System.out.println(sb.toString());
    }

    public static void printProfitResult(LottoResult lottoResult){

        double res = lottoResult.profit();
        System.out.println(String.format(
                        "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)"
                        ,res
                        ,lottoResult.getProfitMessage(res)
                )
        );
    }

    public static void printAutoAndManual(int auto , int manual){
        String resultOfBuying = String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",manual,auto);
        System.out.println();
        System.out.println(resultOfBuying);
    }

}
