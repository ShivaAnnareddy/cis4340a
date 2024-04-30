public class RequestHandler {
    private final Helper helper = new Helper();
    private final ServerSocket server;
    private final ExecutorService exec;
  
    private RequestHandler(int port, int poolSize) throws IOException {
      server = new ServerSocket(port);
      exec = Executors.newFixedThreadPool(poolSize);
    }
  
    public static RequestHandler newInstance(int poolSize) throws IOException {
      return new RequestHandler(0, poolSize); // 0 selects next available port
    }
  
    public void handleRequest() {
      Future<?> future = exec.submit(new Runnable() {
        @Override public void run() {
          try {
            helper.handle(server.accept());
          } catch (IOException e) {
            // Forward to handler
          }
        }
      });
    }
  
    // Consider adding a method to shut down the executor service gracefully
    public void stop() {
      try {
        exec.shutdown();
        exec.awaitTermination(5, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      } finally {
        exec.shutdownNow();
      }
    }
  }
  