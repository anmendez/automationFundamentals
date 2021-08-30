import org.junit.Assert;
import org.testng.annotations.Test;

public class main_test_testNG {
    @Test(groups = {"Imperio"})
    public void testConstructor(){      //This test should pass
        Persona persona = new Persona("Marinet", "Dupain Cheng");
        Assert.assertEquals(persona.getFullName(), "Marinet Dupain Cheng");
    }

    @Test(groups = "Republica")
    public void testChangeName(){       //This test should fail
        Persona persona = new Persona("Marinet", "Dupain Cheng");
        persona.changeName("Ladybug");
        Assert.assertEquals(persona.getFullName(), "Ladybug");
    }

}
