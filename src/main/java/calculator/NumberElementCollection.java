package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberElementCollection {

    List<String> elements;

    public NumberElementCollection(String[] source){
        this.elements = new ArrayList<>();

        for(int i = 0; i < source.length; i++){
            if(!source[i].isEmpty()) {
                this.elements.add(source[i]);
            }
        }
    }

    public int size() {
        return elements.size();
    }
}
