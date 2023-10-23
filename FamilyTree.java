import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class FamilyMember {
    private String name;
    private String gender;
    private FamilyMember parent;
    private List<FamilyMember> children;

    public FamilyMember(String name, String gender, FamilyMember parent) {
        this.name = name;
        this.gender = gender;
        this.parent = parent;
        this.children = new LinkedList<>();
    }

    public void addChild(FamilyMember child) {
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public FamilyMember getParent() {
        return parent;
    }

    public List<FamilyMember> getChildren() {
        return children;
    }
}

class FamilyTree {
    private LinkedList<FamilyMember> members;
    private FamilyMember root;

    public FamilyTree(String rootName, String rootGender) {
        root = new FamilyMember(rootName, rootGender, null);
        members = new LinkedList<>();
        members.add(root);
    }

    public void addMember(String name, String gender, String parentName) {
        FamilyMember parent = findMember(parentName);
        if (parent != null) {
            FamilyMember newMember = new FamilyMember(name, gender, parent);
            parent.addChild(newMember);
            members.add(newMember);
        }
    }

    public List<String> findLineage(String name) {
        FamilyMember person = findMember(name);
        List<String> lineage = new LinkedList<>();
        while (person != null) {
            lineage.add(person.getName());
            person = person.getParent();
        }
        return lineage;
    }

    private FamilyMember findMember(String name) {
        for (FamilyMember member : members) {
            if (member.getName().equals(name)) {
                //System.out.println(member);
                return member;
            }
        }
        return null;
    }
}

public class FamilyTreeDemo {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree("Root", "male");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Family Member");
            System.out.println("2. Find Lineage");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                {
                    System.out.print("Enter the name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the gender (male/female): ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter the parent's name: ");
                    String parentName = scanner.nextLine();
                    familyTree.addMember(name, gender, parentName);
                    System.out.println("Family member added successfully.");
                    break;
                }
                case 2:
                {
                    System.out.print("Enter the name to find lineage: ");
                    String findName = scanner.nextLine();
                    List<String> lineage = familyTree.findLineage(findName);
                    System.out.print("Lineage of " + findName + ": ");
                    for (int i = 0; i < lineage.size(); i++) {
                          System.out.print(lineage.get(i));
                          if (i < lineage.size() - 1) {
                                   System.out.print(" > ");
                                }
                    break;
                }
            }
                case 3:
                {
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
