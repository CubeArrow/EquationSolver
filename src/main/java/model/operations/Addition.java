package model.operations;

import model.tree.Node;

import java.util.List;

public class Addition extends Operation {


    public Addition(List<Node> elements) {
        super(elements);
    }

    @Override
    public float operationFunction(Object[] objects) {
        float result = (float) objects[0];

        for (int i = 1; i < objects.length; i++) {
            result += (float) objects[i];
        }
        return result;
    }
}
