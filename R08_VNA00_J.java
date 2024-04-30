final class ControlledStop implements Runnable {
    private volatile boolean done = false;  // 'volatile' keyword added for visibility across threads
    
    @Override
    public void run() {
      while (!done) {
        try {
          // Hypothetical operation; could be any blocking or time-consuming operation
          Thread.sleep(1000); // Corrected to use static method on Thread class
        } catch (InterruptedException ie) {
          Thread.currentThread().interrupt(); // Properly reset interrupted status
        }
      }
    }
   
    public void shutdown() {
      done = true; // Any thread calling this method will immediately affect visibility in 'run()'
    }
  }
  