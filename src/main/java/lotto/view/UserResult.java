package lotto.view;

public class UserResult {
    private final static String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    private UserResult(){

    }

    public static void countMessage(int count){
        System.out.println(count+LOTTO_COUNT_MESSAGE);
    }
}
