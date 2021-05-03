package domain.Calculator;

public class Calculator {
    public int invalidatedNumber(String nums) {
        if(nums.length()==0){
            return 0;
        }
        String [] num = nums.split(",|:");
        int sum =0;
        for (String i:num) {
            sum += Integer.parseInt(i);
        }
        return sum;
    }
}
