import java.math.BigInteger;
import java.util.Random;

public class CryptoSystem {
    public BigInteger p;
    public BigInteger g;

    public CryptoSystem() throws Exception {
        this.p = BigInteger.probablePrime(512, new Random());
        this.g = calculateG();
    }

    private BigInteger calculateG() throws Exception {
        BigInteger q = p.subtract(new BigInteger("1")).divide(new BigInteger("2"));
        BigInteger temp = p.subtract(new BigInteger("1"));
        for (int i = 0; i < 10; i++) {
            temp = temp.subtract(new BigInteger("1"));
            if (!(power(temp, q).equals(new BigInteger( "1")))) {
                return temp;
            }
        }
        throw new Exception("CANNOT CALCULATE G PARAMETER");
    }
    public BigInteger power(BigInteger base, BigInteger exponent) {
        BigInteger s = base;
        BigInteger y = new BigInteger("1");
        for (int i = 0; i < exponent.bitLength(); i++) {
            if (exponent.testBit(i)) {
             y = y.multiply(s).mod(this.p);
            }
            s = s.multiply(s).mod(this.p);
        }
        return y;
    }

    public void printInfo() {
        System.out.println("CryptoSystem p : " + p);
        System.out.println("CryptoSystem g : " + g);
    }
}
