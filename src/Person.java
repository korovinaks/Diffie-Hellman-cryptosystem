import java.math.BigInteger;
import java.util.Random;

public class Person {
    public String name;
    private BigInteger secretKey;
    public BigInteger publicKey;
    private CryptoSystem system;

    public Person(String name, CryptoSystem system) {
        this.name = name;
        this.secretKey = new BigInteger(1024, new Random());
        this.publicKey = system.power(system.g, secretKey);
        this.system = system;
    }

    public void printInfo() {
        System.out.println(name + " has secret key : " + secretKey);
        System.out.println(name + " has public key : " + publicKey);
    }

    public BigInteger communicate(Person other) {
        BigInteger z = system.power(other.publicKey, secretKey);
        return z;
    }
}
