import java.util.ArrayList;

public class Lotto {
    private final ArrayList<Integer> nums;

    public int numCount() {
        return this.nums.size();
    }

    public Lotto(ArrayList<Integer> nums){
        this.nums = nums;
    }

    public boolean has(int num){
        return this.nums.contains(num);
    }

    public MatchCount match(Lotto other) {
        MatchCount count = new MatchCount();

        for(int num : this.nums){
            count.tryIncrement(other.has(num));
        }

        return count;
    }

    public String print() {
        String str = "[";

        boolean isFirst = true;

        for(int num : this.nums) {
            str = concatNums(str, num, isFirst);
            isFirst = false;
        }

        str += "]";

        return str;
    }

    private String concatNums(String numStr, int num, boolean isFirst){
        if(!isFirst){
            numStr += ", ";
        }

        numStr += num;

        return numStr;
    }
}
