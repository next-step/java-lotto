package study.domain.generator.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import study.domain.generator.NumberGenerator;

public class AutoNumberGenerator implements NumberGenerator {
    
    @Override
    public List<Integer> fetch() {
        List<Integer> mockNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            mockNumbers.add(i);
        }

        Collections.shuffle(mockNumbers);

        List<Integer> resultNumList = mockNumbers.subList(0, 6);
        Collections.sort(resultNumList);
        
        return resultNumList;
    }

}
