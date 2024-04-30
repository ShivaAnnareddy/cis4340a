import java.io.DataInputStream;
import java.io.IOException;

public class IntegerReader {

    public static long getInteger(DataInputStream is) throws IOException {
        return is.readInt() & 0xFFFFFFFFL; // Mask with 32 one-bits to treat as unsigned
    }
}