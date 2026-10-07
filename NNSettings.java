public record NNSettings(
    int[] layerSizes,
    double[][][] weights, //weights[layer][neuron][input]
    double[][] biases,
    int numOfInputs,
    int numOfOutputs
) {


    public NNSettings(int[] layerSizes, double[][][] weights, double[][] biases, int numOfInputs, int numOfOutputs) {


        // validate layerSizes
        if (layerSizes == null) {
            throw new IllegalArgumentException("Layer sizes cannot be null.");
        }
        
        if (layerSizes.length < 1) {
            throw new IllegalArgumentException("There must be at least one layer.");
        }

        for (int i = 0; i < layerSizes.length; i++) {
            if (layerSizes[i] < 1) {
                throw new IllegalArgumentException("Each layer must have at least one neuron.");
            }
        }


        // validate weights
        if (weights == null) {
            throw new IllegalArgumentException("Weights cannot be null.");
        }

        if (weights.length != layerSizes.length + 1) {
            throw new IllegalArgumentException("Weights array length must be one more than the number of layers. (input layer + output layer)");
        }

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] == null) {
                throw new IllegalArgumentException("Weights for layer " + (i + 1) + " cannot be null.");
            }

            try {
                if (weights[i].length != layerSizes[i]) {
                    throw new IllegalArgumentException("Weights for layer " + (i + 1) + " must match the number of neurons in that layer.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                if (weights[i].length != numOfOutputs) {
                    throw new IllegalArgumentException("Weights for the output layer must match the number of outputs.");
                }
            }
            

            for (int j = 0; j < weights[i].length; j++) {
                if (weights[i][j] == null) {
                    throw new IllegalArgumentException("Weights for neuron " + j + " in layer " + (i + 1) + " cannot be null.");
                }

                try {
                    if (weights[i][j].length != layerSizes[i - 1]) {
                        throw new IllegalArgumentException("Each weight vector for neuron " + j + " in layer " + (i + 1) + " must match the number of neurons in the previous layer.");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    if (weights[i][j].length != numOfInputs) {
                        throw new IllegalArgumentException("Each weight vector for neuron " + j + " in the input layer must match the number of inputs.");
                    }
                }
            }
        }

        // validate biases
        if (biases == null) {
            throw new IllegalArgumentException("Biases cannot be null.");
        }
        
        if (biases.length != layerSizes.length) {
            throw new IllegalArgumentException("Biases array length must match the number of layers.");
        }

        for (int i = 0; i < biases.length; i++) {
            if (biases[i] == null) {
                throw new IllegalArgumentException("Biases for layer " + (i + 1) + " cannot be null.");
            }

            if (biases[i].length != layerSizes[i]) {
                throw new IllegalArgumentException("Biases for layer " + (i + 1) + " must match the number of neurons in that layer.");
            }
        }
        
        this.layerSizes = layerSizes;
        this.weights = weights;
        this.biases = biases;
        this.numOfInputs = numOfInputs;
        this.numOfOutputs = numOfOutputs;
    }

}
