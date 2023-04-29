import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] shape = {10, 10, 10};
        MultiArray b = new MultiArray(shape);

        // test direct access
        long startTime = System.nanoTime();
        for (int i = 0; i < shape[0]; i++) {
            for (int j = 0; j < shape[1]; j++) {
                for (int k = 0; k < shape[2]; k++) {
                    double value = b.get(i, j, k);
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Direct access: " + (endTime - startTime) + " nanoseconds");

        // test Ailiff access
        startTime = System.nanoTime();
        for (int j = 0; j < shape[1] * shape[2]; j++) {
            for (int i = 0; i < shape[0]; i++) {
                double value = b.getAiliff(i, j / shape[2], j % shape[2]);
            }
        }
        endTime = System.nanoTime();
        System.out.println("Ailiff access: " + (endTime - startTime) + " nanoseconds");

        // test vector calculation
        startTime = System.nanoTime();
        double[][][] vectors = b.getVectors();
        endTime = System.nanoTime();
        System.out.println("Vector calculation: " + (endTime - startTime) + " nanoseconds");

       
    }
}
