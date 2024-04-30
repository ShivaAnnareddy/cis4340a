import java.math.BigInteger;

public class BigIntegerConversion {

    public static void main(String[] args) {
        BigInteger x = new BigInteger("530500452766");
        // Convert BigInteger to a String that correctly represents its decimal value
        String s = x.toString(); // Valid character data
        
        // Get bytes of the string representation
        byte[] byteArray = s.getBytes();
        
        // Create a new string from the byte array
        String ns = new String(byteArray);
        
        // Convert the string representation back to BigInteger
        x = new BigInteger(ns);
        
        // Output the result to verify correctness
        System.out.println(x);
    }
}
