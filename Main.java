public class Main {
    public static void main(String[] args) {
        double[][] weights = {{1, 2, 3}, {4, 5, 6}};
        double[] biases = {0.5, 1.5};
        Layer layer = new Layer(2, weights, biases);
        double[] inputs = {1, 2, 3};
        double[] outputs = layer.get(inputs);
        for (double output : outputs) {
            System.out.println(output);
        }
    }
}
