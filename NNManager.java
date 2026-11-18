public class NNManager{
  private NN[] models;
  public NNManager(int numOfModels, NNSettings baseSettings){
    this.models = new NN[numOfModels];
    for (int i = 0; i < numOfModels; i++){
      models[i] = new NN(baseSettings);
    }
  }
}
