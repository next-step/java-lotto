import java.util.ArrayList;

public class Tokenizer {
    private String newSplitValue = "";
    private final String defaultSplitValue = ",|;";
    private Boolean splitValueChangedFlag = false;

    public void changeSplitValue(String splitValue){
        newSplitValue = splitValue;

        splitValueChangedFlag = true;
    }

    public String[] splitValue(String inputValue) {
        if (splitValueChangedFlag) {
            return splitWithNewSplitValue(inputValue);
        }
        return splitWithDefaultValue(inputValue);
    }

    public String[] splitWithNewSplitValue(String inputValue){
        return inputValue.split(newSplitValue);
    }

    public String[] splitWithDefaultValue(String inputValue){
        return inputValue.split(defaultSplitValue);
    }
}
