package com.cubearrow.view.utils;

import com.cubearrow.model.tree.Node;
import com.cubearrow.model.tree.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VariableUtilities {
    public static List<Character> getVariableCharSet(HashMap<Variable, Node> variables) {
        ArrayList<Character> resultList = new ArrayList<>();


        variables.forEach((variable, node) -> {
            char variableName = variable.getVariableName();
            if (!resultList.contains(variableName)) {
                resultList.add(variableName);
            }
        });

        return resultList;
    }
}
