package lotto;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_PRICE =  1000;
    private static final int LOTTO_NUMBER =  6;

    private final  List<Integer> lottoLimiteds;

  public Lotto (){
      List<Integer> result =  new ArrayList<>();
      IntStream.range(1, 45).forEach(result::add);
      this.lottoLimiteds = result;
  }
    public List<LottoObject> purChase(List<Integer> lottoSize,int number){
        List<LottoObject> lottoObjects = new ArrayList<>();
        IntStream.range(0,number).forEach( i-> {
                    Collections.shuffle(lottoSize);
                    LottoObject lootObject = new LottoObject();
                    lottoSize.subList(0, LOTTO_NUMBER).forEach(lootObject::add);
                    lottoObjects.add(lootObject);
                }
        );
        return lottoObjects;
    }


    // 당첨 통계 결과 map으로 추출
    public Map<LottoType ,Long>  winningStatistics( List<LottoObject> lottoObjects, List<Integer> winningNumbers, int bonusNumber ){
        return lottoObjects.stream().map(object -> object.contains(winningNumbers,bonusNumber))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // 당첨번호 리스트 추출
    public  List<Integer> winningNumber(String winningText){
        String[] winning = winningText.replace(" ","").split(",");
        return  Arrays.stream(winning).map(Integer::parseInt).collect(Collectors.toList());
    }

    public void lotto(int amount , String winngingText , int bonusNumber){
        System.out.println("구입금액을 입력해 주세요");
        System.out.println(amount);

        int number = amount/LOTTO_PRICE; // 반복 갯수
        System.out.println(number+"개를 구매했습니다.");

        List<LottoObject> lottoObjects = purChase(lottoLimiteds,number); // 구입 한 로또 리스트

        arrayList(lottoObjects); // UI.메소드

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        List<Integer> winningNumbers = winningNumber(winngingText);  // 지난주 당첨 번호 리스트

        System.out.println("보너스 볼을 입력해 주세요..");

        System.out.println(bonusNumber);

        System.out.println("당첨 통계");

        Map<LottoType ,Long> results =winningStatistics(lottoObjects ,winningNumbers ,bonusNumber);// 당첨 통계 메소드

        //System.out.println(results.toString());

        printWinningList(results); // 당첨 통계  ui 메소드

        BigDecimal rate = rateResult(results,amount); // 수익률  계산 메소드

        System.out.println("총 수익률은 "+rate+"입니다.");

       // ga.entrySet().stream().re
    }

    public BigDecimal rateResult(Map<LottoType ,Long>  results, int amount){
        AtomicInteger sum = new AtomicInteger();
        results.forEach((key,value) -> {
            sum.addAndGet(key.getPriceMultiply(value));
        });
        return BigDecimal.valueOf(sum.get()).divide(BigDecimal.valueOf(amount),2,BigDecimal.ROUND_DOWN);
    }
    public void printWinningList( Map<LottoType ,Long>   winningResult){
        winningResult.forEach((key, value) -> System.out.println(key.getPrintString() + "- " + value + "개"));
    }


    public static void main(String[] args){
        System.out.println("구입금액을 입력해 주세요");
       // Scanner scanner = new Scanner(System.in);
        int amount =15000;  // 금액
        int number = amount/LOTTO_PRICE; // 반복 갯수
        System.out.println(number+"개를 구매했습니다.");
        List<Integer> result =  new ArrayList<>();
        IntStream.range(1, 45).forEach(result::add);

        List<LottoObject> lottoObjects = new ArrayList<>();

        IntStream.range(0,number).forEach( i-> {
                    Collections.shuffle(result);
                    LottoObject lootObject = new LottoObject();
                    result.subList(0, LOTTO_NUMBER).forEach(lootObject::add);
                    lottoObjects.add(lootObject);
                }
        );
        arrayList(lottoObjects);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String test = "1, 2, 3, 4, 5, 6";
        String test2 =test.replace(" ","");
        System.out.println(test2);
        String[] test3 = test2.split(",");
        List<Integer> test4= Arrays.stream(test3).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("보너스 볼을 입력해 주세요..");
        int bonusBall = 7;
        System.out.println(bonusBall);
        System.out.println("당첨 통계");
        Map<LottoType ,Long> ga = lottoObjects.stream().map(object -> object.contains(test4,bonusBall))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

      // System.out.println(ga.toString());

        ga.forEach((key, value) -> System.out.println(key.getPrintString() + "- " + value + "개"));
    }

    public static   void arrayList(List<LottoObject> list){
        for (LottoObject object : list){
            System.out.println(object.toString());
        }
    }

}
