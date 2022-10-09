package service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import domain.InputValues;

public class Calculate {

    private static final int CALCULATE_ELEMENTS_SIZE = 3;
    private static final int LAST_ELEMENTS_SIZE = 1;
    private static final int EMPTY_ELEMENTS_SIZE = 0;

    public String calculateInputValue(InputValues inputValues, CalculateCurrentElements calculateCurrentElements) {

        Deque<String> pendingCalculateList = convertListToDeque(inputValues);
        List<String> currentCalculateList = new ArrayList<>();

        while (validatePendingList(pendingCalculateList, currentCalculateList)) {
            currentCalculateList.add(pendingCalculateList.pollFirst());
            pendingCalculateList = calculateCurrentElements.calculateElements(currentCalculateList,
                pendingCalculateList);
            currentCalculateList = cleanCurrentCalculateList(currentCalculateList);
        }
        return pendingCalculateList.element();
    }

    private List<String> cleanCurrentCalculateList(List<String> calTmpArray) {
        if (calTmpArray.size() == CALCULATE_ELEMENTS_SIZE) {
            return new ArrayList<>();
        }
        return calTmpArray;
    }

    private boolean validatePendingList(Deque<String> list, List<String> calTmpArray) {
        return list.size() != LAST_ELEMENTS_SIZE || calTmpArray.size() != EMPTY_ELEMENTS_SIZE;
    }

    private Deque<String> convertListToDeque(InputValues inputValues) {
        return new ArrayDeque<>(Arrays.asList(inputValues.getInputValues()));
    }
}
