import java.math.BigInteger;

public class Main {
    private static void connection(Person first, Person second) {
        BigInteger firstZ = first.communicate(second);
        BigInteger secondZ = second.communicate(first);
        System.out.println(first.name + " -> " + second.name + " : " + firstZ);
        System.out.println(second.name + " -> " + first.name + " : " + secondZ);
        if (firstZ.equals(secondZ)) {
            System.out.println("Connection established");
        }
        else {
            System.out.println("ERROR : connection not established");
        }
    }
    public static void main(String args[]) throws Exception {
        CryptoSystem system = new CryptoSystem();
        system.printInfo();
        Person alice = new Person("Alice", system);
        alice.printInfo();
        Person bob = new Person("Bob", system);
        bob.printInfo();
        Person claire = new Person("Claire", system);
        claire.printInfo();
        connection(alice, bob);
        connection(alice, claire);
        connection(bob, claire);
    }
}
