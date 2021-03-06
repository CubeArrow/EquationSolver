package com.cubearrow.model.utils;

import com.cubearrow.model.tree.nodes.Equation;
import com.cubearrow.model.tree.nodes.operations.Addition;
import com.cubearrow.model.tree.Node;
import com.cubearrow.model.tree.nodes.Number;
import com.cubearrow.model.tree.nodes.Variable;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EquationTest {
    @Test
    public void testToString() {
        Equation equation = new Equation(
                new Addition(new Variable('x'), new Number(5f)),
                new Variable('x')
        );
        assertEquals("The Equation.toString() method does not equal the expected String", "(x+5)=x", equation.toString());
    }


    @Test
    public void getSimpleVariablesTest() {
        Equation equation = new Equation();
        Variable var1 = new Variable('x', equation);
        Variable var2 = new Variable('y', equation);
        equation.setLeft(var1);
        equation.setRight(var2);

        List<Variable> expected = Arrays.asList(var1, var2);
        List<Variable> actual = equation.getVariables();
        assertEquals(expected, actual);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i).getParent(), expected.get(i).getParent());
        }
    }


    @Test
    public void getNestedVariablesTest() {
        Equation equation = new Equation();
        Addition addition = new Addition((Node) null, new Number(3f));
        Variable var1 = new Variable('x', addition);
        Variable var2 = new Variable('y', equation);
        addition.setLeft(var1);
        equation.setLeft(addition);
        equation.setRight(var2);

        List<Variable> expected = Arrays.asList(var1, var2);
        List<Variable> actual = equation.getVariables();
        assert expected.equals(actual);
        for (int i = 0; i < actual.size(); i++) {
            assert actual.get(i).getParent().equals(expected.get(i).getParent());
        }
    }
}
