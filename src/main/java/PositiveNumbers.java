import java.util.List;

public class PositiveNumbers {
    private List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(List<PositiveNumber> positiveNumberList) {
        this.positiveNumbers = positiveNumberList;
    }

    public int sum(){
        int sum = 0;
        for(PositiveNumber positiveNumber:positiveNumbers){
            sum = positiveNumber.addInt(sum);
        }
        return sum;
    }

    private List<PositiveNumber> getPositiveNumberList() {
        return positiveNumbers;
    }
}
