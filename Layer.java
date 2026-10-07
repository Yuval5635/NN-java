public class Layer {

    private Neuron[] neurons;

    public Layer(int numOfNeurons, double[][] weights, double[] biases) {
        neurons = new Neuron[numOfNeurons];
        for (int i = 0; i < numOfNeurons; i++) {
            neurons[i] = new Neuron(weights[i], biases[i]);
        }
    }

    public double[] get(double[] inputs) {
        double[] outputs = new double[neurons.length];
        for (int i = 0; i < neurons.length; i++) {
            outputs[i] = neurons[i].get(inputs);
        }
        return outputs;
    }
}
