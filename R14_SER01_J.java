import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ser implements Serializable {
  private static final long serialVersionUID = 123456789L;

  private Ser() {
    // Initialize
  }

  private void writeObject(final ObjectOutputStream stream)
    throws IOException {
    stream.defaultWriteObject();  // Correctly handles serialization of this instance
  }

  private void readObject(final ObjectInputStream stream)
      throws IOException, ClassNotFoundException {
    stream.defaultReadObject();  // Correctly handles deserialization of this instance
  }
}