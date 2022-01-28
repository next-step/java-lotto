package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Number {

    private String userInput;


    public Number(String userInput) {
        if (isNullOrEmpty(userInput)) {
            userInput = "0";
        }
        this.userInput = userInput;
    }


    public boolean isNullOrEmpty(String userInput) {
        return Objects.isNull(userInput) || userInput.isEmpty();
    }

    public String getNumber() {
        return userInput;
    }

}
