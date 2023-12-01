package step2;

public class ReturnRate {

    private ReturnRate() {
    }

    public static String getReturnRate(int price, int prize){
        double result =  ((double)prize/(double)price);
        return String.valueOf(Math.floor(result * 100) / 100.0);
    }
}
