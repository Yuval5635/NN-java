public class Main {
    public static void main(String[] args) {
        NNSettings settings = new NNSettings(
            new int[]{2, 2}, // layer sizes
            new double[][][]{
                {{1, 1, 1}, {1, 1, 1}}, // weights for layer 1
                {{1, 1}, {1, 1}}, // weights for layer 2
                {{1, 1}} // weights for output layer
            },
            new double[][]{
                {0, 0}, // biases for layer 1
                {0, 0}, // biases for layer 2
            },
            3, // number of inputs
            1 // number of outputs
        );

        NN nn = new NN(settings);
        System.out.println("Output: " + nn.get(new double[]{1, 2, 3})[0]); //Result: Output: 
    }
}
