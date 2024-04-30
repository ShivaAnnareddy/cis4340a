public class SafeAddition {

    public static int getAbsAdd(int x, int y) {
        // Check for the edge case where x or y is Integer.MIN_VALUE
        if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Input should not be Integer.MIN_VALUE because its absolute value is out of int range.");
        }

        int absX = Math.abs(x);
        int absY = Math.abs(y);

        // Check for potential overflow
        if (absX > Integer.MAX_VALUE - absY) {
            throw new IllegalArgumentException("The absolute sum of x and y should not exceed Integer.MAX_VALUE.");
        }

        return absX + absY;
    }

    public static void main(String[] args) {
        try {
            System.out.println(getAbsAdd(1000, 2000)); // Example use case
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}