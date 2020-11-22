package stringaddcalculator.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import stringaddcalculator.domain.Separator;
import stringaddcalculator.view.InputView;
import stringaddcalculator.view.ResultView;

public class StringAddCalculator {
    List<String> selector = new ArrayList<>();

    private InputView inputView;
    private ResultView resultView;

    public StringAddCalculator(InputView inputView, ResultView resultView){
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void operator(){
        String input = inputView.input();
        Separator separator = new Separator();

        String[] array = sortValue(input, separator);
        int result = branch(array);
        resultView.printResult(result);
    }

    public String[] sortValue(String value, Separator separator){
        String[] result = null;
        if(!value.contains("//")){
            String temp = removeSeparator(value, separator);
            result = temp.split("");
            return result;
        }
        result = findCumstomSeparator(value, separator);

        return result;
    }

    public String removeSeparator(String value, Separator separator){
        String result = value;
        for(String str : separator.getSeparator()){
            result = result.replace(str, "");
        }
        return result;
    }

    public String[] findCumstomSeparator(String value, Separator separator){
        String custom = addSeparator(value, separator);

        String temp = value.replace("//"+custom+"\\n", custom);
        temp = removeSeparator(temp, separator);

        String[] result = temp.split("");

        return result;
    }

    public String addSeparator(String value, Separator separator){
        String custom = "";
        Pattern pattern = Pattern.compile("[/][/](.*?)[\\\\]");
        Matcher matcher = pattern.matcher(value);

        while(matcher.find()){
            custom = matcher.group(1);
            separator.addCustumSeparator(custom);
        }
        return custom;
    }

    public int branch(String[] nums){
        int count = 0;
        int result = 0;

        for(int i = 0 ; i < nums.length; i++){
            validateValue(nums[i]);
            int num1 = Integer.parseInt(nums[i]);
            int num2 = Integer.parseInt(nums[i+1]);
            result = selector(num1, num2, result, count);
            count++;
            if(count == nums.length-1){
                break;
            }
        }
        
        return result;
    }

    public void validateValue(String str){
        if(!Character.isDigit(str.charAt(0)) || str.equals("-")){
            throw new RuntimeException("This value is not correct, Please check your input values");

        };
    }

    public int selector(int num1, int num2, int result, int count){
        if(count == 0){
            return add(num1, num2);
        }
        return add(result, num2);
    }

    public int add(int num1, int num2){

        return num1+num2;
    }
}
