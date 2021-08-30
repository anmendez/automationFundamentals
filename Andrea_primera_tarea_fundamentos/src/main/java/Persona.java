public class Persona {
    private String name;                                //This is an Object Persona with attributes
    private String lastName;

    public Persona(String name, String lastName){
        this.name = name;                               // This is a constructor
        this.lastName = lastName;
    }

    public void changeName(String newName){
        this.name = newName;                            //This is a method(what we call function)
    }

    public String getFullName(){
        return this.name + " " + this.lastName;         ////This is another method
    }
}

/*If we want to add Junit, all we need to do is adding a dependecy to our POM
All you need to do is to google "Junit for Maven" is will give you the maven repo
Choose a version of preference and copy its dependencies. Go ahead and paste those in your POM
Now give right click Maven > Reload project

If we want to add testNG, we will do the same thing, google "testNG for Maven" this will give you, again, the maven repo
Choose a version of preference and copy its dependencies. Go ahead and paste those in your POM
Now give right click Maven > Reload project
*/