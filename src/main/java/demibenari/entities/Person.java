package demibenari.entities;

import java.io.Serializable;

/**
 *
 * Created by Demi Ben-Ari on 4/2/16.
 */
public class Person implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
