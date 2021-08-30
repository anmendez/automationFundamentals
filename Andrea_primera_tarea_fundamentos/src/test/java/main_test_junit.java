import org.junit.Assert;
import org.junit.Test;
//This is junit for unit testing
public class main_test_junit {
    @Test                          //this test should pass
    public void testConstructor(){
        Persona persona = new Persona("Marinet", "Dupain Cheng");
        Assert.assertEquals("Marinet Dupain Cheng", persona.getFullName());
    }

    @Test                         //this test should fail
    public void testChangeName(){
        Persona persona = new Persona("Marinet", "Dupain Cheng");
        persona.changeName("Ladybug");
        persona.getFullName();
        Assert.assertEquals("Ladybug", persona.getFullName());
    }
}
