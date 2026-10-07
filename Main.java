public class Main {
    public static void main(String[] args) {
        Neuron neuron = new Neuron(new double[]{2}, 1);
        double output = neuron.get(new double[]{2});
        System.out.println("Output: " + output);
    }
}
