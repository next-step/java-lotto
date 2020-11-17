package lotto.view;

import util.CommonUtils;

import java.util.List;

public class ResultView {
    private final static String NUMBERS_DELIMITER = ", ";
    private final static String BUY_MESSAGE = "개를 구매했습니다.";

    public void printBuyMessage(int count) {
        System.out.println(count + BUY_MESSAGE);
    }

    public void printLottoes(List<List<Integer>> lottos){
        lottos.stream()
                .map(CommonUtils::listToArray)
                .map(this::convertNumbersFormat)
                .forEach(System.out::println);
    }

    private String convertNumbersFormat(String[] strings){
        return "["+String.join(NUMBERS_DELIMITER,strings)+"]";
    }


}
