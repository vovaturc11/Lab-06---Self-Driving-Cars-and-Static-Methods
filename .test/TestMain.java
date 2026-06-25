import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.fail;

public class TestMain {
    @Test
    @DisplayName("Method Created")
    void testMethodCreated()
    {
        Class<?> classObj = null;
        try
        {
            classObj = Class.forName("Main");
        } catch (ClassNotFoundException e)
        {
            fail("No Main class found");
        }
        Method[] methods = classObj.getDeclaredMethods();

        boolean found = false;
        for (Method method : methods) {
            if (method.getReturnType().equals(Void.TYPE)
                    && method.getParameters().length == 0) {
                found = true;
            }
        }

        if (!found) {
            fail("A void method that doesn't have parameters was not found in Main");
        }
    }

    /*
    TBD: Implement a Method Called test

    @Test
    @DisplayName("Method Called")
    void testMethodCalled()
    {
       // Mock the method created by the user and use verify?
    }

     */
}