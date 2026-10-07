public class NN {

    Layer[] layers;

    public NN(NNSettings settings) {
        
        layers = new Layer[settings.layerSizes().length + 1];
        for (int i = 0; i < settings.layerSizes().length; i++) {
            layers[i] = new Layer(settings.layerSizes()[i], settings.weights()[i], settings.biases()[i]);
        }
        layers[settings.layerSizes().length] = new Layer(settings.numOfOutputs(), settings.weights()[settings.layerSizes().length], new double[settings.numOfOutputs()]);
    }

    public double[] get(double[] inputs) {
        double[] outputs = inputs;
        for (Layer layer : layers) {
            outputs = layer.get(outputs);
            System.out.println("Layer output: " + java.util.Arrays.toString(outputs));
        }
        return outputs;
    }
}
