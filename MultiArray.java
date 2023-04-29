public class MultiArray {
    private final int[] shape;
    private final double[] data;

    public MultiArray(int[] shape) {
        this.shape = shape;
        this.data = new double[shape[0] * shape[1] * shape[2]];
    }

    public double get(int i, int j, int k) {
        return data[i * shape[1] * shape[2] + j * shape[2] + k];
    }

    public void set(int i, int j, int k, double value) {
        data[i * shape[1] * shape[2] + j * shape[2] + k] = value;
    }

    public double getAiliff(int i, int j, int k) {
        return data[i * shape[1] * shape[2] + j + k * shape[1]];
    }

    public void setVector(double[][] vector) {
        for (int i = 0; i < shape[0]; i++) {
            for (int j = 0; j < shape[1]; j++) {
                for (int k = 0; k < shape[2]; k++) {
                    data[i * shape[1] * shape[2] + j + k * shape[1]] = vector[k][j * shape[0] + i];
                }
            }
        }
    }
    public double[][][] getVectors() {
        double[][][] vectors = new double[shape[1] * shape[2]][shape[0]][1];
        for (int j = 0; j < shape[1] * shape[2]; j++) {
            for (int i = 0; i < shape[0]; i++) {
                vectors[j][i][0] = getAiliff(i, j / shape[2], j % shape[2]);
            }
        }
        return vectors;
    }

}
