package lotto;

import java.util.*;
import java.util.concurrent.Flow;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_PRICE =  1000;
    private static final int LOTTO_NUMBER =  6;


    public void purChase(String amount){
    }

    public static void main(String[] args){
        System.out.println("구입금액을 입력해 주세요");
       // Scanner scanner = new Scanner(System.in);
        int amount =15000;  // 금액
        int number = amount/LOTTO_PRICE; // 반복 갯수
        System.out.println(number+"개를 구매했습니다.");
        List<Integer> result =  new ArrayList<>();
        IntStream.range(1, 50).forEach(result::add);

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
        Map<LottoType ,Long> ga = lottoObjects.stream().map(object ->{
            return object.contains(test4,bonusBall);})
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(ga.toString());



    }

    public static   void arrayList(List<LottoObject> list){
        for (LottoObject object : list){
            System.out.println(object.toString());
        }
    }

}
