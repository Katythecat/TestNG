package PV;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.CustomListeners.class)
public class ListenersDemo {
    @Test
    void test1(){
        System.out.println("This is test 1");
        Assert.assertEquals("A","A");
    }

    @Test
    void test2(){
        System.out.println("This is test 2");
        Assert.assertEquals("A","B");
    }

    @Test
    void test3(){
        System.out.println("This is test 3");
        throw new SkipException("This is skip exception");
    }
}
