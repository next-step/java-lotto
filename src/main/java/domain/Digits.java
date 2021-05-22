package domain;

import java.util.ArrayList;
import java.util.List;

public class Digits {
    private List<Digit> digits;

    public Digits(List<Digit> digits) {
        this.digits = digits;
    }

    public Digits(String[] tokens){
        digits = new ArrayList<>();
        for (String token : tokens) {
            digits.add(new Digit(token));
        }
    }

    public int size(){
        return digits.size();
    }

    public int sum() {
        int result = 0;
        for (Digit digit : digits) {
            result += digit.digit();
        }
        return result;
    }
}
