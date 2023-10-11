import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int birthYear;
    private String gender;
    private List<Person> children;

    public Person(String name, int birthYear, String gender) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public List<Person> getChildren() {
        return children;
    }
}

public class FamilyTree {
    public static void printLineage(Person person, int level) {
        String indentation = "  ".repeat(level);
        System.out.println(indentation + person.getName() + " (" + person.getBirthYear() + ", " + person.getGender() + ")");
        for (Person child : person.getChildren()) {
            printLineage(child, level + 1);
        }
    }

    public static void main(String[] args) {
        Person grandparent1 = new Person("Alice", 1950, "Female");
        Person grandparent2 = new Person("Bob", 1952, "Male");
        Person parent1 = new Person("Charlie", 1975, "Male");
        Person parent2 = new Person("Diana", 1980, "Female");
        Person child1 = new Person("Eva", 2005, "Female");
        Person child2 = new Person("Frank", 2010, "Male");

        grandparent1.addChild(parent1);
        grandparent1.addChild(parent2);
        parent1.addChild(child1);
        parent2.addChild(child2);

        printLineage(grandparent1, 0);
    }
}

