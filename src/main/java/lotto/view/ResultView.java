package lotto.view;

public class ResultView {

    private static String STATISTIC_FORMAT = "%s개 일치 (%s원)- %s개";

    public static void show4thStat(int count){
        System.out.println(
                String.format(STATISTIC_FORMAT,3,5000,count)
        );
    }

    public static void show3thStat(int count){
        System.out.println(
                String.format(STATISTIC_FORMAT,4,50000,count)
        );
    }

    public static void show2thStat(int count){
        System.out.println(
                String.format(STATISTIC_FORMAT,5,1500000,count)
        );
    }

    public static void show1thStat(int count){
        System.out.println(
                String.format(STATISTIC_FORMAT,6,2000000000,count)
        );
    }
}
