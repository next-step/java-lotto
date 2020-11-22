package stringaddcalculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {

    private List<String> separator;

    public Separator(){
        this.separator =  new ArrayList<String>(Arrays.asList(",", ":"));
    }

    public List<String> getSeparator(){
        return separator;
    }

    public void addCustumSeparator(String value){
        this.separator.add(value);
    }
}
